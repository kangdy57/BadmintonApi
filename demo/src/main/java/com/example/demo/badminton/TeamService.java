package com.example.demo.badminton;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, TeamRepository team) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeam() {
        return teamRepository.findAll();
    }

    public void addNewTeam(Team team) {
        Optional<Team> teamOptional = teamRepository.findTeamByName(team.getTeamName());
        if(teamOptional.isPresent()) {
            throw new IllegalStateException("Name taken");
        }
        teamRepository.save(team);
    }

    public void deleteTeam(Long teamId) {
        teamRepository.existsById(teamId);
        boolean exists = teamRepository.existsById(teamId);
        if(!exists) {
            throw new IllegalStateException("team with id " + teamId + " does not exists");
        }
        teamRepository.deleteById(teamId);
    }

    @Transactional
    public void updateTeam(Long teamId, String name, String position) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalStateException("team with id " + teamId + "does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(team.getTeamName(), name)) {
            team.setTeamName(name);
        }

        if(position != null && position.length() > 0 && !Objects.equals(team.getPosition(), position)) {
            team.setPosition(position);
        }
    }
}
