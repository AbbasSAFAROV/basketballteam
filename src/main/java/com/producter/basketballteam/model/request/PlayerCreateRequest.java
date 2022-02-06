package com.producter.basketballteam.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayerCreateRequest {

    private String name;
    private String surname;
    private Long position_id;
    private Long team_id;

}
