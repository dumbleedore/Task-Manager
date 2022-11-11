package com.lucas.taskmanager.controller;

import com.lucas.taskmanager.model.Tarefa;
import com.lucas.taskmanager.model.TarefaDTO;
import com.lucas.taskmanager.service.TarefaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

class TarefaControllerTest {
    public static final long ID = 1L;
    public static final String TAREFA = "tarefa";
    public static final String DESCRICAO = "descricao";
    public static final String DATA = "data";
    public static final String STATUS = "status";
    @InjectMocks
    TarefaController tarefaController;
    @Mock
    ModelMapper modelMapper;
    @Mock
    TarefaService service;
    Tarefa tarefa;
    TarefaDTO tarefaDTO;
    Tarefa tarefaUpdated;
    @BeforeEach
    void beforeAll(){
        MockitoAnnotations.openMocks(this);
        init();
    }
    @Test
    void whenRunGetTarefas() {
        Mockito.when(service.getAllTarefas()).thenReturn(List.of(tarefa));
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(tarefaDTO);
        ResponseEntity<List<TarefaDTO>> response = tarefaController.getTarefas();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1,response.getBody().size());
        Assertions.assertEquals(1,response.getBody().get(0).getId());
    }

    @Test
    void whenRunCreateTarefa() {
        Mockito.when(service.createTarefa(Mockito.any())).thenReturn(tarefa);
        ResponseEntity<Tarefa> response = tarefaController.createTarefa(tarefa);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(1,response.getBody().getId());
    }

    @Test
    void whenRunDeleteTarefa() {
        Mockito.when(service.deleteTarefa(Mockito.anyLong())).thenReturn(tarefa);
        Mockito.when(modelMapper.map(Mockito.any(),Mockito.any())).thenReturn(tarefaDTO);
        Mockito.when(service.doesTaskExist(Mockito.anyLong())).thenReturn(true);
        ResponseEntity<TarefaDTO> response = tarefaController.deleteTarefa((int)ID);
        Assertions.assertEquals(1,response.getBody().getId());
        Assertions.assertEquals(TarefaDTO.class,response.getBody().getClass());
        Assertions.assertNotNull(response);
    }

    @Test
    void whenUpdateTarefa() {
        Mockito.when(service.updateTarefa(Mockito.anyLong(),Mockito.any()))
                .thenReturn(tarefaUpdated);
        Mockito.when(service.doesTaskExist(Mockito.anyLong())).thenReturn(true);
        ResponseEntity<TarefaDTO> response = tarefaController.updateTarefa(1,tarefa);
        System.out.println(response.getBody());
    }

    void init(){
        tarefa = new Tarefa(ID, TAREFA, DESCRICAO, DATA, STATUS);
        tarefaDTO = new TarefaDTO(ID, TAREFA, DESCRICAO, DATA, STATUS);
        tarefaUpdated = new Tarefa(2L,TAREFA,DESCRICAO,DATA,STATUS);
    }
}