package com.producter.basketballteam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<Player> players;

    public Position(Long id, String position) {
        this.id = id;
        this.position = position;
    }

    public Position(String position) {
        this.position = position;
    }
}
