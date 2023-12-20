package com.example.demo.badminton;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository.findPlayerByName(player.getName());
        if(playerOptional.isPresent()) {
            throw new IllegalStateException("Name taken");
        }
        playerRepository.save(player);
    }

    public void deletePlayer(Long playerId) {
        playerRepository.existsById(playerId);
        boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("player with id " + playerId + " does not exists");
        }
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(Long playerId, String name, String position) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException("player with id " + playerId + "does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(player.getName(), name)) {
            player.setName(name);
        }

        if(position != null && position.length() > 0 && !Objects.equals(player.getPosition(), position)) {
            player.setPosition(position);
        }
    }
}
