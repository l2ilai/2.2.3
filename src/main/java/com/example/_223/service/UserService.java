package com.example._223.service;

import com.example._223.dao.UserRepository;
import com.example._223.model.entity.Car;
import com.example._223.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Car car;

    public List<User> getUsers() {
        Flux<User> employeeFlux = WebClient
                .create("https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income")
                .get()
                .retrieve()
                .bodyToFlux(User.class);

        return employeeFlux
                .collect(Collectors.toList())
                .share().block();
    }

    public List<User> getUserWithCar() {
        List<User> users = getUsers();
        return users.stream()
                .peek(user -> user.setCar(car.getNewCarOrNull()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        List<User> usersList = getUserWithCar();
        usersList.forEach(System.out::println);
        userRepository.saveAll(usersList);
    }

}
