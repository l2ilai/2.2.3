package com.example._223.controller;

import com.example._223.service.LoanCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanRestController {

    @Autowired
    private LoanCalculation loanCalculation;

    @GetMapping("/loan")
    public double showAmountLoan(@RequestParam(value = "userId", required = false) Long id) {
        return loanCalculation.getLoan(id);
    }
}
