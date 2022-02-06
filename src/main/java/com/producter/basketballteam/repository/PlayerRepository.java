package com.producter.basketballteam.repository;

import com.producter.basketballteam.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
