package com.example.demo.badminton;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table
public class Game {
    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_sequence"
    )

    private Long gameId;
    private Long servePlayer;
    private LocalTime breakTime;
    private Long winner;
    private Long loser;

    public Game() {
    }

    public Game(Long gameId, Long servePlayer, LocalTime breakTime, Long winner, Long loser) {
        this.gameId = gameId;
        this.servePlayer = servePlayer;
        this.breakTime = breakTime;
        this.winner = winner;
        this.loser = loser;
    }

    public Game(Long servePlayer, LocalTime breakTime, Long winner, Long loser) {
        this.servePlayer = servePlayer;
        this.breakTime = breakTime;
        this.winner = winner;
        this.loser = loser;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getServePlayer() {
        return servePlayer;
    }

    public void setServePlayer(Long servePlayer) {
        this.servePlayer = servePlayer;
    }

    public LocalTime getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(LocalTime breakTime) {
        this.breakTime = breakTime;
    }

    public Long getWinner() {
        return winner;
    }

    public void setWinner(Long winner) {
        this.winner = winner;
    }

    public Long getLoser() {
        return loser;
    }

    public void setLoser(Long loser) {
        this.loser = loser;
    }
}
