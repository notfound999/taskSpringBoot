package com.example.demo.domain.dto;

public record ErrorRespond(
        int status,
        String message,
        String details
) {
}
