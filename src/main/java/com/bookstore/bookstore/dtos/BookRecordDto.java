package com.bookstore.bookstore.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto(String title, int stock ,UUID publisherId, Set<UUID> authorIds, String reviewComment) {
}
