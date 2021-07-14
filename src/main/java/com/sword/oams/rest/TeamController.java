package com.sword.oams.rest;

import com.sword.oams.domain.Team;
import com.sword.oams.payload.request.TeamRequest;
import com.sword.oams.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("")
    List<Team> allTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("")
    Team addTeam(@RequestBody TeamRequest request) {
        return teamService.addTeam(request);
    }

    @GetMapping("/{id}")
    Team getTeam(@PathVariable Long id) { return teamService.getTeamById(id); }

    @PutMapping("/{id}")
    Team updateTeam(@RequestBody TeamRequest request,@PathVariable Long id) { return teamService.updateTeamById(id, request); }

    @DeleteMapping("/{id}")
    void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeamById(id);
    }
}
