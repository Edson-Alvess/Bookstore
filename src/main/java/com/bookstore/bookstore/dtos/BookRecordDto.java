package com.bookstore.bookstore.dtos;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public record BookRecordDto(String title, int stock, BigDecimal price, UUID publisherId, Set<UUID> authorIds, String reviewComment) {
}
