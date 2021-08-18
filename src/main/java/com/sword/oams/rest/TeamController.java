package com.sword.oams.rest;

import com.sword.oams.domain.Team;
import com.sword.oams.payload.request.TeamRequest;
import com.sword.oams.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oams/teams")
@Api(tags = "Teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("")
    @ApiOperation(value = "This method is used to get all teams.")
    List<Team> allTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to add a team.")
    ResponseEntity<?> addTeam(@RequestBody TeamRequest request) {
        return teamService.addTeam(request);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "This method is used to get a team by its ID.")
    Team getTeam(@PathVariable Long id) { return teamService.getTeamById(id); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to update a team by its ID.")
    Team updateTeam(@RequestBody TeamRequest request,@PathVariable Long id) { return teamService.updateTeamById(id, request); }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiOperation(value = "This method is used to delete a team by its ID.")
    void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeamById(id);
    }
}
