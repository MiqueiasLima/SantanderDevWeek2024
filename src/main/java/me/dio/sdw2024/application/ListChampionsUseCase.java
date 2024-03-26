package me.dio.sdw2024.application;

import me.dio.sdw2024.domain.model.Champions;
import me.dio.sdw2024.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionsRepository championsRepository) {

    public List<Champions> findAll(){
        return championsRepository.findAll();
    }

}
