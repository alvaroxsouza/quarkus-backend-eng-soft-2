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

    private TeamRepository rivalRepository;

    @Inject
    public TeamService(TeamRepository rivalRepository) {
        super();
        this.rivalRepository = rivalRepository;
    }

    public List<TeamRepresentation> getAllTeams() {
        return this.rivalRepository.all().stream().map(TeamRepresentation::new).collect(Collectors.toList());
    }

    public void addTeam(Team time) {
        this.rivalRepository.add(time);
    }

    public void updateTeam(TeamDto rivalDto) {
        Team time = this.rivalRepository.get(rivalDto.getId());
        time.updateTeam(rivalDto);
    }

    public void deleteTeam(Long id) {
        Team time = this.rivalRepository.get(id);
        this.rivalRepository.remove(time);
    }

    public TeamRepresentation getTeamById(Long id) {
        Team time = this.rivalRepository.get(id);
        return new TeamRepresentation(time);
    }
}
