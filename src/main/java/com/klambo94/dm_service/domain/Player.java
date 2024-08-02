package com.klambo94.dm_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String classType;
    private Integer initiative;
    private Integer passivePerception;

    public Player(String name, String classType, Integer initiative, Integer passivePerception) {
        this.name = name;
        this.classType = classType;
        this.initiative = initiative;
        this.passivePerception = passivePerception;
    }
}
