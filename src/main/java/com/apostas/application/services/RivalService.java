package com.apostas.application.services;

import com.apostas.application.dto.RivalDto;
import com.apostas.application.representation.RivalRepresentation;
import com.apostas.domain.game.rival.Rival;
import com.apostas.domain.repository.RivalRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class RivalService {

    private RivalRepository rivalRepository;

    @Inject
    public RivalService(RivalRepository rivalRepository) {
        super();
        this.rivalRepository = rivalRepository;
    }

    public List<RivalRepresentation> getAllRivals() {
        return this.rivalRepository.all().stream().map(RivalRepresentation::new).collect(Collectors.toList());
    }

    public void addRival(Rival rival) {
        this.rivalRepository.add(rival);
    }

    public void updateRival(RivalDto rivalDto) {
        Rival rival = this.rivalRepository.get(rivalDto.getId());
        rival.updateRival(rivalDto);
    }

    public void deleteRival(Long id) {
        Rival rival = this.rivalRepository.get(id);
        this.rivalRepository.remove(rival);
    }

    public RivalRepresentation getRivalById(Long id) {
        Rival rival = this.rivalRepository.get(id);
        return new RivalRepresentation(rival);
    }
}
