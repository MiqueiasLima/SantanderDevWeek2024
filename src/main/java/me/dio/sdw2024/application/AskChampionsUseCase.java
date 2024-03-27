package me.dio.sdw2024.application;

import me.dio.sdw2024.domain.exception.ChampionNotFoundException;
import me.dio.sdw2024.domain.model.Champion;
import me.dio.sdw2024.ports.ChampionsRepository;
import me.dio.sdw2024.ports.GenerativeAIService;

public record AskChampionsUseCase(ChampionsRepository championsRepository, GenerativeAIService generativeAIService) {
    public String askChampion(Long id, String question){
        Champion champion = championsRepository.findById(id).orElseThrow(() ->
                new ChampionNotFoundException(id));

        String championContext = champion.generateContextByQuestion(question);

        String objective = """
                    Atue como uma assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL)
                    Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                    Segue a pergunta, o nome do campeão e sua respectiva lore (História):
                    
                """;

        generativeAIService.generateContent(objective,championContext);

        return championContext;
    }
}
