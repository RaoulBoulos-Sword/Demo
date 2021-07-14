package com.sword.oams.service;

import com.sword.oams.domain.Team;
import com.sword.oams.payload.request.TeamRequest;
import com.sword.oams.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getAllTeams() { return teamRepository.findAll(); }

    public Team getTeamById(Long id) { return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Team Not Found"));}

    public void deleteTeamById(Long id) { teamRepository.deleteById(id); }

    public Team addTeam(TeamRequest request) {
        Team newTeam = Team.builder()
                .name(request.getName())
                .build();
        return teamRepository.save(newTeam);
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
