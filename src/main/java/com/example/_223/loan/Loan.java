package com.example._223.loan;

import org.springframework.stereotype.Component;

@Component
public class Loan {

    private Float amount;

    public Loan() {
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
