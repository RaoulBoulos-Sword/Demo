package com.sword.oams.service;

import com.sword.oams.domain.Team;
import com.sword.oams.payload.request.TeamRequest;
import com.sword.oams.payload.response.MessageResponse;
import com.sword.oams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAllTeams() { return teamRepository.findAll(); }

    public Team getTeamById(Long id) { return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Team Not Found"));}

    public void deleteTeamById(Long id) { teamRepository.deleteById(id); }

    public ResponseEntity<?> addTeam(TeamRequest request) {
        if(teamRepository.existsByName(request.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Team already exists !"));
        }

        Team newTeam = Team.builder()
                .name(request.getName())
                .build();

        teamRepository.save(newTeam);

        return ResponseEntity.ok(new MessageResponse("Success: Team added."));
    }

    public Team updateTeamById(Long id, TeamRequest request) {
        return teamRepository.findById(id)
                .map(team -> {
                    team.setName(request.getName());
                    return teamRepository.save(team);
                })
                .orElse(null);
    }
}
