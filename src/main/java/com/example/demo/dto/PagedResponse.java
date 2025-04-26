package com.example.demo.dto;

import java.util.List;

public record PagedResponse<T>(long totalElements, int totalPages, int size, int page, List<T> content) {
}
