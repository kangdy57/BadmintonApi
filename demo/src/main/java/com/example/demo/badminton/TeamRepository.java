package com.example.demo.badminton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

    @Query("SELECT t FROM Team t WHERE t.teamName = ?1")
    Optional<Team> findTeamByName(String Name);
}
