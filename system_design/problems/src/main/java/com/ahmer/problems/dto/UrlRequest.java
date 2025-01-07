package com.ahmer.problems.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class UrlRequest {
    private String originalUrl;
    private LocalDateTime expiryDate;

    // Getters and Setters
    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
