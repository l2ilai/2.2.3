package com.example._223.model.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import static com.example._223.model.entity.Car.getRandomNumber;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Transient
    private Integer income;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User(Integer income) {
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
                "id=" + id +
                ", income=" + income +
                ", car=" + car +
                '}';
    }
}
