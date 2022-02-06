package com.producter.basketballteam.api.graphQL;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.producter.basketballteam.model.dto.PlayerDto;
import com.producter.basketballteam.service.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final PlayerService playerService;
    private final ModelMapper mapper;

    public PlayerQueryResolver(PlayerService playerService, ModelMapper mapper) {
        this.playerService = playerService;
        this.mapper = mapper;
    }

    public List<PlayerDto> getAllPlayers(){
        return playerService.getAllPlayers().stream().map(player -> mapper.map(player,PlayerDto.class)).collect(Collectors.toList());
    }

    public PlayerDto getPlayerById(Long id){
        return mapper.map(playerService.findPlayerById(id),PlayerDto.class);
    }

}
