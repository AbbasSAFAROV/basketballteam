package com.producter.basketballteam.api.graphQL;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.producter.basketballteam.model.dto.PlayerDto;
import com.producter.basketballteam.model.request.PlayerCreateRequest;
import com.producter.basketballteam.service.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerService playerService;
    private final ModelMapper mapper;

    public PlayerMutationResolver(PlayerService playerService, ModelMapper mapper) {
        this.playerService = playerService;
        this.mapper = mapper;
    }

    public PlayerDto createPlayer(PlayerCreateRequest request){
        return mapper.map(playerService.createPlayer(request),PlayerDto.class);
    }

    public String deletePlayerById(Long id){
        playerService.deletePlayerById(id);
        return "player deleted id:"+id;
    }


}
