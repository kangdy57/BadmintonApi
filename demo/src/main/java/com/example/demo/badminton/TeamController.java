package com.example.demo.badminton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getTeam() {
        return teamService.getTeam();
    }
    @PostMapping
    public void registerNewTeam (@RequestBody Team team) {
        teamService.addNewTeam(team);
    }
    @DeleteMapping(path = "{teamId}")
    public void deleteTeam(@PathVariable("teamId") Long teamId) {
        teamService.deleteTeam(teamId);
    }
    @PutMapping(path = "{teamId}")
    public void updateTeam (
            @PathVariable("teamId") Long teamId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position) {
        teamService.updateTeam(teamId, name, position);
    }





}
