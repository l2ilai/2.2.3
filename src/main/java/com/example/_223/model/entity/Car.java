package com.example._223.model.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Random;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private Integer price;


    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
