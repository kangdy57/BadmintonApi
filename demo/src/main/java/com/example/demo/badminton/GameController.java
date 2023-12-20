package com.example.demo.badminton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/game")

public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGame() {
        return gameService.getGame();
    }
    @PostMapping
    public void registerNewGame (@RequestBody Game game) {
        gameService.addNewGame(game);
    }
    @DeleteMapping(path = "{gameId}")
    public void deleteGame(@PathVariable("gameId") Long gameId) {
        gameService.deleteGame(gameId);
    }
    @PutMapping(path = "{gameId}")
    public void updateGame (
            @PathVariable("gameId") Long gameId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position) {
        gameService.updateGame(gameId, name, position);
    }


}
