package com.example._223.service;

import com.example._223.model.entity.Car;
import com.example._223.model.entity.User;
import com.example._223.properties.LoanProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoanCalculation {

    @Autowired
    private UserService userService;

    @Autowired
    private LoanProperties loanProperties;

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

    public boolean isApprovedLoan(User userFromAPI, User userFromDB) {
        return getIncomeUserOrZero(userFromAPI) > loanProperties.getMinimalIncome() ||
                getPriceCarOrZero(userFromDB.getCar()) > loanProperties.getPriceCar();
    }


    public double calculateMaxAmountLoan(User userFromAPI, User userFromDB) {
        Integer incomeUser = getIncomeUserOrZero(userFromAPI);
        double halfAnnualIncome = incomeUser * 6.0;
        Integer priceCar = getPriceCarOrZero(userFromDB.getCar());
        double thirtyPercentCostCar = priceCar * 0.3;
        return Math.max(halfAnnualIncome, thirtyPercentCostCar);
    }

    public double getLoan(Long id) {
        User userFromAPI = userService.getUsers().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
        User userFromDB = userService.getUserById(id);
        if (isApprovedLoan(userFromAPI, userFromDB)) {
            return calculateMaxAmountLoan(userFromAPI, userFromDB);
        }
        return 0;
    }
}
