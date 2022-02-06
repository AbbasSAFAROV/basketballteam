package com.producter.basketballteam.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamDto {

    private Long id;
    private String name;
    private Integer capacity;

}
