package com.example._223.service;

import com.example._223.dao.UserRepository;
import com.example._223.model.entity.Car;
import com.example._223.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.example._223.service.CarService.getNewCarOrNull;
import static com.example._223.service.CarService.getRandomNumber;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void setCarForUser(User user) {
        Car car = getNewCarOrNull();
        user.setCar(car);
        if (car != null) {
            user.getCar().setPrice(getRandomNumber());
        }
    }
}
