package com.lucas.taskmanager.service;

import com.lucas.taskmanager.model.Tarefa;
import com.lucas.taskmanager.repository.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TarefaServiceTest {
    @InjectMocks
    private TarefaService tarefaService;
    @Mock
    private TarefaRepository tarefaRepository;
    private Tarefa tarefa;
    @BeforeEach
    void beforeAlltests(){
        init();
    }
    @Test
    void whenRunGetAllTarefas() {
        Mockito.when(tarefaService.getAllTarefas()).thenReturn(List.of(tarefa));
        List<Tarefa> response = tarefaService.getAllTarefas();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1,response.size());

    }

    @Test
    void createTarefa() {
    }

    @Test
    void deleteTarefa() {
    }

    @Test
    void getAllTarefas() {
    }

    @Test
    void updateTarefa() {
    }
    void init(){
        tarefa = new Tarefa("primeira Tarefa","desc","data","aberta");
    }
}