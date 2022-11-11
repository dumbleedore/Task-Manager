package com.lucas.taskmanager.controller;

import com.lucas.taskmanager.exceptions.ResourceNotFoundException;
import com.lucas.taskmanager.model.Tarefa;
import com.lucas.taskmanager.model.TarefaDTO;
import com.lucas.taskmanager.service.TarefaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/tarefas")
    public ResponseEntity<List<TarefaDTO>> getTarefas() {
       List<TarefaDTO> tasks = tarefaService.getAllTarefas().stream().map(task ->
               modelMapper.map(task, TarefaDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(tasks);
    }
    @PostMapping("/createTarefa")
    @ResponseBody
    public ResponseEntity<Tarefa> createTarefa(@RequestBody Tarefa tarefa){
        return ResponseEntity.ok().body(tarefaService.createTarefa(tarefa));
    }
    @DeleteMapping("/deleteTarefa/{id}")
    @ResponseBody
    public ResponseEntity<Tarefa> deleteTarefa(@PathVariable Integer id){
            if(tarefaService.doesTaskExist(Long.valueOf(id))){
                Tarefa tarefaDeletada = tarefaService.deleteTarefa(Long.valueOf(id));
                return ResponseEntity.ok().body(tarefaDeletada);
            }
            throw new ResourceNotFoundException("There's no task to delete with that ID");

    }
    @PutMapping("/updateTarefa/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Integer id, @RequestBody Tarefa tarefa){

            if(tarefaService.doesTaskExist(Long.valueOf(id))){
                Tarefa tarefaAtualizada = tarefaService.updateTarefa(Long.valueOf(id), tarefa);
                return ResponseEntity.ok().body(tarefaAtualizada);
            }
            throw new ResourceNotFoundException("There's no task with that ID");

    }

    
}
