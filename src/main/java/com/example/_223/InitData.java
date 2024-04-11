package com.example._223;

import com.example._223.model.entity.User;
import com.example._223.mapper.UserMapper;
import com.example._223.service.IncomeClient;
import com.example._223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData {

    @Autowired
    private UserService userService;

    @Autowired
    private IncomeClient incomeClient;

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserWithCar() {
        return incomeClient.getClient().stream()
                .map(userMapper::toUser)
                .peek(userService::setCarForUser)
                .toList();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<User> usersList = getUserWithCar();
        usersList.forEach(System.out::println);
        userService.saveAll(usersList);
    }
}
