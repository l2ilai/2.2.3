package com.example._223.controller;

import com.example._223.service.LoanCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private LoanCalculation loanCalculation;

    @GetMapping("/loan")
    public double showUser(@RequestParam(value = "userId", required = false) Long id) {
        return loanCalculation.getLoan(id);
    }
}
