package com.example._223.loan;

import com.example._223.model.entity.Car;
import com.example._223.model.entity.User;
import com.example._223.service.UserService;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;


@Configuration
@ConfigurationProperties(prefix = "loan")
public class LoanCalculation {

    @Autowired
    private UserService userService;

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

    public Integer getPriceCarOrZero(Car car) {
        return Optional.ofNullable(car)
                .map(Car::getPrice)
                .orElse(0);
    }

public Integer getIncomeUserOrZero(User user) {
        return Optional.ofNullable(user)
                .map(User::getIncome)
                .orElse(0);
    }

    public boolean isApprovedLoan(User user) {
        return user.getIncome() > minimalIncome || getPriceCarOrZero(user.getCar()) > priceCar;
    }


    public double calculateMaxAmountLoan(User user) {
        Integer incomeUser = getIncomeUserOrZero(user);
        double halfAnnualIncome = incomeUser * 6.0;
        Integer priceCar = getPriceCarOrZero(user.getCar());
        double thirtyPercentCostCar = priceCar * 0.3;
        return Math.max(halfAnnualIncome, thirtyPercentCostCar);
    }

    public double getLoan(Long id) {
        User user = userService.getUserById(id);
        if (isApprovedLoan(user)) {
            return calculateMaxAmountLoan(user);
        }
        return 0;
    }
}
