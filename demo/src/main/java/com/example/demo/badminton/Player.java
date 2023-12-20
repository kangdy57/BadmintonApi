package com.example.demo.badminton;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )
    private Long id;
    private String position;
    private String name;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Player(Long id, String position, String name, LocalDate dob) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.dob = dob;
    }

    public Player(String position, String name, LocalDate dob) {
        this.position = position;
        this.name = name;
        this.dob = dob;
    }

    public Player() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
