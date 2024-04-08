package com.example._223.loan;

import com.example._223.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "loan")
public class LoanCalculation {

    @Autowired
    private Loan loan;

    @Autowired
    private User user;

    private Integer minimalIncome;

    private Integer priceCar;

    public Integer getMinimalIncome() {
        return minimalIncome;
    }

    public void setMinimalIncome(Integer minimalIncome) {
        this.minimalIncome = minimalIncome;
    }

    public Integer getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(Integer priceCar) {
        this.priceCar = priceCar;
    }

    public boolean isApprovedLoan(User user, Integer minimalIncome, Integer priceCar) {
        return user.getIncome() > minimalIncome || user.getCar().getPrice() > priceCar;
    }
    public Integer calculateAmountLoan() {
        //TODO

        return null;
    }
}
