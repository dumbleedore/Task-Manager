package com.lucas.taskmanager.service;

import com.lucas.taskmanager.model.Tarefa;
import com.lucas.taskmanager.repository.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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

    private Tarefa tarefaUpdated;
    @BeforeEach
    void beforeAlltests(){

        init();
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void whenRunGetAllTarefas() {
        Mockito.when(tarefaRepository.findAll()).thenReturn(List.of(tarefa));
        List<Tarefa> response = tarefaService.getAllTarefas();
        Assertions.assertEquals(1,response.size());
        Assertions.assertNotNull(response);
        Assertions.assertEquals(tarefa,response.get(0));
    }

    @Test
    void whenRunCreateTarefa() {
        Mockito.when(tarefaRepository.save(any())).thenReturn(tarefa);
        Tarefa response = tarefaService.createTarefa(tarefa);
        Assertions.assertNotNull(response);
        Assertions.assertEquals("primeira Tarefa",response.getNome());
    }
    @Test
    void whenRunDeleteTarefa(){
        Mockito.when(tarefaRepository.findById(Mockito.anyLong())).thenReturn(opTarefa);
        Tarefa response = tarefaService.deleteTarefa(ID);
        Assertions.assertEquals(response.getId(),opTarefa.get().getId());
        Assertions.assertNotNull(response);
        Assertions.assertEquals(Tarefa.class,response.getClass());

    }
    @Test
    void whenRunUpdateTarefa() {
        Mockito.when(tarefaRepository.findById(Mockito.anyLong())).thenReturn(opTarefa);
        Tarefa response = tarefaService.updateTarefa(ID,tarefaUpdated);
        Assertions.assertEquals("Tarefa atualizada",response.getNome());
        Assertions.assertNotNull(response);
        Assertions.assertEquals(Tarefa.class,response.getClass());


    }
    void init(){
        tarefa = new Tarefa(
                ID, PRIMEIRA_TAREFA
                , DESC, DATA, ABERTA);
        opTarefa = Optional.of(new Tarefa(
                ID, PRIMEIRA_TAREFA
                , DESC, DATA, ABERTA));
        tarefaUpdated = new Tarefa(
                2L,"Tarefa atualizada",
                "desc 2","data 2","fechada"
        );
    }
}