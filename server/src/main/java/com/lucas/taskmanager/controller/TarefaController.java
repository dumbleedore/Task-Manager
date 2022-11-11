package com.lucas.taskmanager.controller;

import com.lucas.taskmanager.exceptions.ResourceNotFoundException;
import com.lucas.taskmanager.model.Tarefa;
import com.lucas.taskmanager.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;
    @GetMapping("/tarefas")
    public ResponseEntity<List<Tarefa>> getTarefas() {
        return ResponseEntity.ok().body(tarefaService.getAllTarefas());
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
    @PutMapping("/updateTarefa")
    public ResponseEntity<Tarefa> updateTarefa(@RequestParam Integer id, @RequestBody Tarefa tarefa){
            Tarefa tarefaAtualizada = tarefaService.updateTarefa(Long.valueOf(id), tarefa);
            return ResponseEntity.ok().body(tarefaAtualizada);

    }

    
}
