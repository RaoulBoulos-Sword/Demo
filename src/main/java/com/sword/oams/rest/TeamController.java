package com.sword.oams.rest;

import com.sword.oams.domain.Team;
import com.sword.oams.exception.TeamNotFoundException;
import com.sword.oams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/teams")
public class TeamController {
    @Autowired
    TeamRepository teamRepository;

    @GetMapping("")
    List<Team> allTeams() {
        return teamRepository.findAll();
    }

    @PostMapping("")
    Team addTeam(@RequestBody Team newTeam) {
        return teamRepository.save(newTeam);
    }

    @GetMapping("/{id}")
    Team getTeam(@PathVariable Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    @PutMapping("/{id}")
    Team updateTeam(@RequestBody Team newTeam,@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    void deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
    }
}
