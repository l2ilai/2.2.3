package com.example._223;

import com.example._223.service.UserDtoService;
import com.example._223.model.entity.Car;
import com.example._223.model.entity.User;
import com.example._223.model.mapper.Mapper;
import com.example._223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;
import static com.example._223.service.CarService.getNewCarOrNull;
import static com.example._223.service.CarService.getRandomNumber;

@Component
public class InitData {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDtoService userDtoService;

    @Autowired
    private Mapper mapper;

    public List<User> getUserWithCar() {
        return userDtoService.getClient().stream()
                .map(mapper::toUser)
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
