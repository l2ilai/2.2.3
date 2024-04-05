package com.example._223.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Integer income;

    public User(Long id, Integer income) {
        this.id = id;
        this.income = income;
    }

    public User() {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", income=" + getIncome() +
                '}';
    }
}
