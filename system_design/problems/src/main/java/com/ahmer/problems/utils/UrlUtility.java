package com.ahmer.problems.utils;

import com.ahmer.problems.dto.UrlResponse;
import com.ahmer.problems.model.Url;
import org.apache.commons.lang3.RandomStringUtils;

public class UrlUtility {
    public static UrlResponse mapToResponse(Url url) {
        UrlResponse response =
                new UrlResponse(url.getShortUrl(), url.getOriginalUrl());
        return response;
    }

    public static String generateShortUrl() {
        return RandomStringUtils.randomAlphanumeric(8); // Generates an 8-character string
    }
}
