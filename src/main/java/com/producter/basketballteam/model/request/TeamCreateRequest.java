package com.producter.basketballteam.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamCreateRequest {

    private String name;
    private Integer capacity;

}
