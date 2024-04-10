package com.example._223.model.dto;

public class UserDTO {

    private Long id;

    private Integer income;

    public UserDTO(Long id, Integer income) {
        this.id = id;
        this.income = income;
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }
}
