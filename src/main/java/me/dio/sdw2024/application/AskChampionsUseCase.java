package me.dio.sdw2024.application;

import me.dio.sdw2024.domain.exception.ChampionNotFoundException;
import me.dio.sdw2024.domain.model.Champion;
import me.dio.sdw2024.ports.ChampionsRepository;

import java.util.List;

public record AskChampionsUseCase(ChampionsRepository championsRepository) {
    public String askChampion(Long id, String question){
        Champion champion = championsRepository.findById(id).orElseThrow(() ->
                new ChampionNotFoundException(id));

        String championContext = champion.generateContextByQuestion(question);

        //Todo: Evoluir a lógica de negócio para considerar a Integração com IA's Generativas
        return championContext;
    }
}
