package me.dio.sdw2024.application;

import me.dio.sdw2024.domain.model.Champions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListChampionUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    @Test
    public void testListChampions(){
       List<Champions> championsList = listChampionsUseCase.findAll();
        Assertions.assertEquals(12,championsList.size());
    }
}