package com.example.runners.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }


    @PostConstruct
    private void init() {
        runs.add( new Run(
                1 ,
                "Monday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(15, ChronoUnit.MINUTES),
                2,
                Location.INDOOR
        ));

        runs.add( new Run(
                2 ,
                "Friday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(6, ChronoUnit.MINUTES),
                1,
                Location.OUTDOOR
        ));
    }
}
