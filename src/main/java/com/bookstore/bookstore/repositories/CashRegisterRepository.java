package com.bookstore.bookstore.repositories;

import com.bookstore.bookstore.models.CashRegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CashRegisterRepository extends JpaRepository<CashRegisterModel, UUID> {
    CashRegisterModel findFirstByOrderByIdAsc();
}
