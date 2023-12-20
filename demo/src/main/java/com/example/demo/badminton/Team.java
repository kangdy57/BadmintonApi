package com.example.demo.badminton;
import jakarta.persistence.*;

@Entity
@Table
public class Team {

    @Id
    @SequenceGenerator(
            name = "team_sequence",
            sequenceName = "team_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "team_sequence"
    )
    private Long teamId;
    private String teamName;
    private Long player1Id;
    private Long player2Id;
    private Long score;
    private String position;
    private Long set;

    public Team() {
    }

    public Team(Long teamId, String teamName, Long player1Id, Long player2Id, Long score, String position, Long set) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.score = score;
        this.position = position;
        this.set = set;
    }

    public Team(String teamName, Long player1Id, Long player2Id, Long score, String position, Long set) {
        this.teamName = teamName;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
        this.score = score;
        this.position = position;
        this.set = set;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        teamName = teamName;
    }

    public Long getPlayer1Id() {
        return player1Id;
    }

    public void setPlayer1Id(Long player1Id) {
        this.player1Id = player1Id;
    }

    public Long getPlayer2Id() {
        return player2Id;
    }

    public void setPlayer2Id(Long player2Id) {
        this.player2Id = player2Id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getSet() {
        return set;
    }

    public void setSet(Long set) {
        this.set = set;
    }
}
