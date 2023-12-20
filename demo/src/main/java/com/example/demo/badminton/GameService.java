package com.example.demo.badminton;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository, GameRepository game) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGame() {
        return gameRepository.findAll();
    }

    public void addNewGame(Game game) {
        Optional<Game> gameOptional = gameRepository.findGameById(game.getGameId());
        if(gameOptional.isPresent()) {
            throw new IllegalStateException("Name taken");
        }
        gameRepository.save(game);
    }

    public void deleteGame(Long gameId) {
        gameRepository.existsById(gameId);
        boolean exists = gameRepository.existsById(gameId);
        if(!exists) {
            throw new IllegalStateException("team with id " + gameId + " does not exists");
        }
        gameRepository.deleteById(gameId);
    }

    @Transactional
    public void updateGame(Long gameId, String name, String position) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalStateException("game with id " + gameId + "does not exist"));

        if(gameId != null && !Objects.equals(game.getGameId(), gameId)) {
            game.setGameId(gameId);
        }

    }
}
