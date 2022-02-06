package com.producter.basketballteam.config;


import com.producter.basketballteam.entity.Player;
import com.producter.basketballteam.entity.Position;
import com.producter.basketballteam.entity.Team;
import com.producter.basketballteam.model.request.PlayerCreateRequest;
import com.producter.basketballteam.model.request.PositionCreateRequest;
import com.producter.basketballteam.model.request.TeamCreateRequest;
import com.producter.basketballteam.repository.PlayerRepository;
import com.producter.basketballteam.repository.PositionRepository;
import com.producter.basketballteam.repository.TeamRepository;
import com.producter.basketballteam.service.PlayerService;
import com.producter.basketballteam.service.PositionService;
import com.producter.basketballteam.service.TeamService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

     final TeamRepository teamRepository;
     final PositionRepository positionRepository;
     final PlayerRepository playerRepository;

    public DataLoader(TeamRepository teamRepository, PositionRepository positionRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.positionRepository = positionRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Team teamA = new Team("teamA",12);

        Position PG = new Position("PG");
        Position SG = new Position("SG");
        Position SF = new Position("SF");
        Position PF = new Position("PF");
        Position C = new Position("C");

        Player player1 = new Player("playerOneName","playerOneSurname",PG,teamA);


    }
}
