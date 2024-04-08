package com.example._223.model;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import static com.example._223.model.Car.getRandomNumber;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column
    private Integer income;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @PrimaryKeyJoinColumn
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
        if (car != null) {
            this.car.setId(this.getId());
            this.car.setPrice(getRandomNumber());
            this.car.setUser(this);
        }
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
