package com.example._223.service;

import com.example._223.model.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CarService {

    @Autowired
    private UserService userService;

    public Integer getPriceCarOrZero(Long id) {
        Car car = userService.getUserById(id).getCar();
        return Optional.ofNullable(car)
                .map(Car::getPrice)
                .orElse(0);
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 200_000) + 900_000;
    }

    public static Car getNewCarOrNull() {
        Random myRand = new Random();
        if (myRand.nextBoolean()) {
            return null;
        }
        return new Car();
    }
}
