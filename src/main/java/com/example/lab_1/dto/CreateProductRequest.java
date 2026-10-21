package com.example.lab_1.dto;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        BigDecimal price,
        Long categoryId) {
}
