package com.example._223.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Entity
@Table(name = "cars")
@Component
public class Car {

    @Id
    @Column(name = "user_id")
    private Long id;

    @Column
    private Integer price;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
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

    public static int getRandomNumber() {
        return (int) (Math.random() * 200_000) + 900_000;
    }

    public Car getNewCarOrNull() {
        Random myRand = new Random();
        if (myRand.nextBoolean()) {
            return null;
        }
        return new Car();
    }
}
