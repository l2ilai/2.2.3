package com.example._223.loan;

import org.springframework.stereotype.Component;

@Component
public class Loan {

    private Double amount;

    public Loan() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
