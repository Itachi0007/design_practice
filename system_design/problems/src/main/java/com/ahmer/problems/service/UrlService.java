package com.ahmer.problems.service;

import com.ahmer.problems.dto.UrlRequest;
import com.ahmer.problems.dto.UrlResponse;
import com.ahmer.problems.model.Url;
import com.ahmer.problems.repository.UrlRepository;
import com.ahmer.problems.utils.UrlUtility;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final RedisTemplate<String, String> redisTemplate;

    private static final long CACHE_TTL = 1L; // Cache TTL in hours

    public UrlService(UrlRepository urlRepository, RedisTemplate<String, String> redisTemplate) {
        this.urlRepository = urlRepository;
        this.redisTemplate = redisTemplate;
    }

    public UrlResponse createShortUrl(UrlRequest urlRequest) {
        Optional<Url> existingUrl = urlRepository.findByOriginalUrl(urlRequest.getOriginalUrl());
        if (existingUrl.isPresent()) {
            return UrlUtility.mapToResponse(existingUrl.get());
        } else if (urlRequest.getOriginalUrl() == null || urlRequest.getOriginalUrl().isBlank()) {
            throw new IllegalArgumentException("Original URL posted as blank");
        }

        String shortUrl = UrlUtility.generateShortUrl();

        Url url = new Url();
        url.setOriginalUrl(urlRequest.getOriginalUrl());
        url.setShortUrl(shortUrl);
        url.setCreatedOn(LocalDateTime.now());
        url.setExpiresOn(urlRequest.getExpiryDate()); // "2025-12-31T23:59:59"

        Url savedUrl = urlRepository.save(url);

        // Store in Redis
        redisTemplate.opsForValue().set(shortUrl, urlRequest.getOriginalUrl(), CACHE_TTL, TimeUnit.HOURS);

        return UrlUtility.mapToResponse(savedUrl);
    }

    public UrlResponse getOriginalUrl(String shortUrl) {
        // Check Redis cache
        String originalUrl = redisTemplate.opsForValue().get(shortUrl);
        if (originalUrl != null) {
            System.out.println("URL fetched from cache");
            UrlResponse response = new UrlResponse(shortUrl,originalUrl);
            return response;
        }

        // Fallback to database
        Url url = urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new IllegalArgumentException("Short URL not found: " + shortUrl));

        // Update Redis cache
        redisTemplate.opsForValue().set(shortUrl, url.getOriginalUrl(), CACHE_TTL, TimeUnit.HOURS);

        UrlResponse response = new UrlResponse(url.getShortUrl(), url.getOriginalUrl());
        return response;
    }

    public List<UrlResponse> getAllUrls() {
        List<Url> urls = urlRepository.findAll();
        return urls.stream().map(UrlUtility::mapToResponse).toList();
    }
}
