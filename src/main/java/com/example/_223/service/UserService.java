package com.example._223.service;

import com.example._223.dao.UserRepository;
import com.example._223.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    @Transactional
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

}
