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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class TarefaServiceTest {
    public static final Long ID = 1L;
    public static final String PRIMEIRA_TAREFA = "primeira Tarefa";
    public static final String DESC = "desc";
    public static final String DATA = "data";
    public static final String ABERTA = "aberta";
    @InjectMocks
    private TarefaService tarefaService;
    @Mock
    private TarefaRepository tarefaRepository;
    private Tarefa tarefa;
    private Optional<Tarefa> opTarefa;
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
    void whenRunCreateTarefa() {
        Mockito.when(tarefaRepository.save(any())).thenReturn(tarefa);
        Tarefa response = tarefaService.createTarefa(tarefa);
        Assertions.assertNotNull(response);
        Assertions.assertEquals("primeira Tarefa",response.getNome());
    }





    @Test
    void getAllTarefas() {
    }

    @Test
    void updateTarefa() {
    }
    void init(){
        tarefa = new Tarefa(
                ID, PRIMEIRA_TAREFA
                , DESC, DATA, ABERTA);
        opTarefa = Optional.of(new Tarefa(
                ID, PRIMEIRA_TAREFA
                , DESC, DATA, ABERTA));
    }
}