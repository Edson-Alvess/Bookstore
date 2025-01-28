package com.bookstore.bookstore.models;

import com.bookstore.bookstore.repositories.CashRegisterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CashRegisterInitializer implements CommandLineRunner {
    private final CashRegisterRepository cashRegisterRepository;

    public CashRegisterInitializer(CashRegisterRepository cashRegisterRepository){
        this.cashRegisterRepository = cashRegisterRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        if (cashRegisterRepository.findAll().isEmpty()){
            CashRegisterModel initialCashRegister = new CashRegisterModel();
            cashRegisterRepository.save(initialCashRegister);
        }
    }

}
