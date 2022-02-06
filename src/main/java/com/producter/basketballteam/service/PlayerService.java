package com.producter.basketballteam.service;


import com.producter.basketballteam.entity.Player;
import com.producter.basketballteam.entity.Position;
import com.producter.basketballteam.entity.Team;
import com.producter.basketballteam.exception.PlayerNotFoundException;
import com.producter.basketballteam.model.dto.PlayerDto;
import com.producter.basketballteam.model.dto.TeamDto;
import com.producter.basketballteam.model.request.PlayerCreateRequest;
import com.producter.basketballteam.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamService teamService;
    private final PositionService positionService;
    private final ModelMapper modelMapper;

    public PlayerService(PlayerRepository playerRepository, TeamService teamService, PositionService positionService, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.teamService = teamService;
        this.positionService = positionService;
        this.modelMapper = modelMapper;
    }

    public List<PlayerDto> getAllPlayers(){
        return playerRepository.findAll().stream().map(player -> modelMapper.map(player,PlayerDto.class)).collect(Collectors.toList());
    }

    public PlayerDto createPlayer(PlayerCreateRequest request){

        Team team = teamService.findTeamById(request.getTeam_id());
        Position position = positionService.findPositionById(request.getPosition_id());

        Player player = new Player(request.getName(), request.getSurname(), position,team);
        return modelMapper.map(player,PlayerDto.class);
    }

    public PlayerDto updatePlayerById(PlayerCreateRequest request, Long id){

        Player existPlayer = findPlayerById(id);

        Team team = teamService.findTeamById(request.getTeam_id());
        Position position = positionService.findPositionById(request.getPosition_id());

        Player updatedPlayer = new Player(existPlayer.getId(), request.getName(), request.getSurname(), position,team);
        return modelMapper.map(updatedPlayer,PlayerDto.class);
    }

    public void deletePlayerById(Long id){
        playerRepository.delete(findPlayerById(id));
    }

    public Player findPlayerById(Long id){
        return playerRepository.findById(id).orElseThrow(()->new PlayerNotFoundException("Player not found id:"+id));
    }


}
