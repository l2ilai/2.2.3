package com.example._223.controller;

import com.example._223.loan.LoanCalculation;
import com.example._223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private LoanCalculation loanCalculation;

    @GetMapping("/loan")
    public String showUser(@RequestParam(value = "userId", required = false) Long id, Model model) {
        model.addAttribute("loanAmount", loanCalculation.getLoan(id));
        return "loan";
    }
}
