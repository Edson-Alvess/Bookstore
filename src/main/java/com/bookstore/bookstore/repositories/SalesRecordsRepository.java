package com.bookstore.bookstore.repositories;

import com.bookstore.bookstore.models.SalesRecordsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesRecordsRepository extends JpaRepository<SalesRecordsModel, UUID> {
}
