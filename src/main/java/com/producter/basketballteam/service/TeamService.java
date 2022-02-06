package com.producter.basketballteam.service;


import com.producter.basketballteam.entity.Team;
import com.producter.basketballteam.exception.TeamNotFoundException;
import com.producter.basketballteam.model.dto.TeamDto;
import com.producter.basketballteam.model.request.TeamCreateRequest;
import com.producter.basketballteam.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    public TeamService(TeamRepository teamRepository, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
    }

    public List<TeamDto> getAllTeams(){
        return teamRepository.findAll().stream().map(team->modelMapper.map(team,TeamDto.class)).collect(Collectors.toList());
    }

    public TeamDto createTeam(TeamCreateRequest request){
        Team team = modelMapper.map(request,Team.class);
        return modelMapper.map(teamRepository.save(team),TeamDto.class);
    }

    public TeamDto updateTeam(TeamCreateRequest request, Long id){
        Team existTeam = findTeamById(id);
        Team updatedTeam = teamRepository.save(new Team(existTeam.getId(),request.getName(),request.getCapacity()));
        return modelMapper.map(updatedTeam,TeamDto.class);
    }

    public void deleteTeamById(Long id){
        teamRepository.delete(findTeamById(id));
    }

    public Team findTeamById(Long id){
        return teamRepository.findById(id).orElseThrow(()->new TeamNotFoundException("team not found id:"+id));
    }



}
