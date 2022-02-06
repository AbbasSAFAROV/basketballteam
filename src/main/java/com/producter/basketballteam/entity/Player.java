package com.producter.basketballteam.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Position position;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    public Player(String name, String surname, Position position, Team team) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.team = team;
    }
}
