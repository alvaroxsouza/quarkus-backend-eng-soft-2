package com.apostas.application.services;

import com.apostas.application.dto.TeamDto;
import com.apostas.application.representation.TeamRepresentation;
import com.apostas.domain.game.Team;
import com.apostas.domain.repository.TeamRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class TeamService {

    private TeamRepository teamRepository;

    @Inject
    public TeamService(TeamRepository teamRepository) {
        super();
        this.teamRepository = teamRepository;
    }

    public List<TeamRepresentation> getAllTeams() {
        return this.teamRepository.all().stream().map(TeamRepresentation::new).collect(Collectors.toList());
    }

    public void addTeam(Team time) {
        this.teamRepository.add(time);
    }

    public void updateTeam(TeamDto teamDto) {
        Team team = this.teamRepository.get(teamDto.getId());
        team.updateTeam(teamDto);
    }

    public void deleteTeam(Long id) {
        Team team = this.teamRepository.get(id);
        this.teamRepository.remove(team);
    }

    public TeamRepresentation getTeamById(Long id) {
        Team team = this.teamRepository.get(id);
        return new TeamRepresentation(team);
    }
}
