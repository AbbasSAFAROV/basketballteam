package com.producter.basketballteam.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerDto {

    private Long id;
    private String name;
    private String surname;
    private String position_id;
    private String team_id;

}
