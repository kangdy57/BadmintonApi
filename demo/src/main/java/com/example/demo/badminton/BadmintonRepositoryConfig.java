package com.example.demo.badminton;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class BadmintonRepositoryConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository){
        return args -> {
           Player dayeon = new Player(
                   "Left",
                   "Da Yeon",
                   LocalDate.of(1994, Month.MAY, 7)
           );
            Player sude = new Player(
                    "Right",
                    "Sude",
                    LocalDate.of(2000, Month.JANUARY, 1)
            );
            playerRepository.saveAll(List.of(dayeon,sude));

            Player alex = new Player(
                    "Right",
                    "Alex",
                    LocalDate.of(2001, Month.JANUARY, 2)
            );

            Player leonie = new Player(
                    "Left",
                    "Leonie",
                    LocalDate.of(1999, Month.JANUARY, 3)
            );

            playerRepository.saveAll(List.of(dayeon,sude,alex,leonie));
        };
    }

    @Bean
    CommandLineRunner commandLineRunnerTeam(TeamRepository teamRepository){
        return args -> {
            Team hamburgSV = new Team(
                    "HamburgSV",
                    1L,
                    2L,
                    9L,
                    "Left",
                    2L
            );

            Team berlinSV = new Team(
                    "BerlinSV",
                    3L,
                    4L,
                    13L,
                    "Right",
                    2L
            );
            teamRepository.saveAll(List.of(hamburgSV, berlinSV));
        };
    }

    @Bean
    CommandLineRunner commandLineRunnerGame(GameRepository gameRepository){
        return args -> {
            Game first = new Game (
                    1000L,
                    LocalTime.of(12,10,00),
                    100L,
                    101L
            );
            gameRepository.saveAll(List.of(first));
        };
    }
}
