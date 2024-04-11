package com.example._223.service;

import com.example._223.model.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncomeClient {

    public List<UserDTO> getClient() {
        Flux<UserDTO> employeeFlux = WebClient
                .create("https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income")
                .get()
                .retrieve()
                .bodyToFlux(UserDTO.class);

        return employeeFlux
                .collect(Collectors.toList())
                .share().block();
    }

    public Integer getIncomeUserOrZero(Long id) {
        UserDTO userDTO = getClient().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(userDTO)
                .map(UserDTO::getIncome)
                .orElse(0);
    }
}
