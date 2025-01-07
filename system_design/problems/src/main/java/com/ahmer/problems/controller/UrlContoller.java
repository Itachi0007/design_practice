package com.ahmer.problems.controller;

import com.ahmer.problems.dto.UrlRequest;
import com.ahmer.problems.dto.UrlResponse;
import com.ahmer.problems.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class UrlContoller {

    private final UrlService urlService;

    public UrlContoller(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping
    public ResponseEntity<List<UrlResponse>> getAllUrls() {
        List<UrlResponse>urls =  urlService.getAllUrls();
        return ResponseEntity.ok(urls);
    }

    @PostMapping("/originalurl")
    public ResponseEntity<?> createShortUrl(@Valid @RequestBody UrlRequest urlRequest) {
        try {
            UrlResponse response = urlService.createShortUrl(urlRequest);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new UrlResponse(null, "Invalid request: " + e.getMessage()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body("An unexpected error occurred");
        }
    }

    @GetMapping("/originalurl/{url}")
    public ResponseEntity<?> getOriginalUrl(@PathVariable String url) {
        try {
            UrlResponse response = urlService.getOriginalUrl(url);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body("An unexpected error occurred");

        }
    }
}
