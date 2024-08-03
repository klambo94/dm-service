package com.klambo94.dm_service.controllers;

import com.klambo94.dm_service.domain.Player;
import com.klambo94.dm_service.repositories.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController("/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/new")
    public void addNewPlayer(@RequestBody Player player) throws Exception {
        log.info("Adding new player: {}", player);
        if(player == null) {
            throw new Exception("No Player was submitted!");
        }

        if(player.getName().isEmpty()) {
            throw new Exception("Player Name is required");
        }

        if(player.getClassType().isEmpty() || player.getInitiative() == null
                || player.getPassivePerception() == null) {
            throw new Exception("Player details are required");
        }

        playerRepository.save(player);
        log.info("New Player Added!");

    }

    @GetMapping("/player/${id}")
    public Player getPlayer(Long id) {
        log.info("Looking for player: {}", id);

        if(id == null || id > 0) {
            throw new RuntimeException("Invalid Request id");
        }

        return playerRepository.findById(id).orElseThrow();
    }

    @GetMapping("/players")
    public Iterable<Player> getPlayers() {
        log.info("Getting player list");

        return playerRepository.findAll();
    }

    @DeleteMapping("/player/${id}/delete")
    public void deletePlayer(@RequestParam Long id) {
        log.info("Deleting player: {}", id);

        if(id == null || id > 0) {
            throw new RuntimeException("Invalid Request id");
        }

        playerRepository.deleteById(id);
        log.info("Player Deleted!");
    }

    @PostMapping("/player/{id}/update")
    public void updatePlayer(Long id, @RequestBody Player player) {
        log.info("Updating player: {}", id);
        log.info("New player info: {}", player);

        if(id == null || id > 0) {
            throw new RuntimeException("Invalid Request id");
        }

        if(!playerRepository.existsById(id)) {
            throw new RuntimeException("Invalid Request id: Player Not Found");
        }

        playerRepository.save(player);
        log.info("Player Updated!");
    }

    @GetMapping("/passiveWisdom")
    public List<Integer> fetchPlayersWisdom() {

    }
}
