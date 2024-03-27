package me.dio.sdw2024;

import me.dio.sdw2024.application.AskChampionsUseCase;
import me.dio.sdw2024.application.ListChampionsUseCase;
import me.dio.sdw2024.ports.ChampionsRepository;
import me.dio.sdw2024.ports.GenerativeAIService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients
@SpringBootApplication
public class SantanderDevWeek2024Application {

	public static void main(String[] args) {
		SpringApplication.run(SantanderDevWeek2024Application.class, args);
	}
	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository championsRepository){
		return new ListChampionsUseCase(championsRepository);
	}

	@Bean
	public AskChampionsUseCase provideAskChampionsUseCase(ChampionsRepository championsRepository, GenerativeAIService genAiservice){
		return new AskChampionsUseCase(championsRepository, genAiservice);
	}
}
