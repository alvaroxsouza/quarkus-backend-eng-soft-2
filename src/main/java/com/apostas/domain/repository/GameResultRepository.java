package com.apostas.domain.repository;

import com.apostas.domain.bet.GameResult;

import java.util.List;

public interface GameResultRepository extends Repository<GameResult, Long> {
    List<GameResult> getByGameResult(Long id);
}
