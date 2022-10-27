package com.lucas.taskmanager.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lucas.taskmanager.model.Tarefa;
import com.lucas.taskmanager.service.TarefaService;
@RestController
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;
    @GetMapping("/tarefas")
    public String getTarefas() {
        return "tarefas";
    }
    @PostMapping("/createTarefa")
    @ResponseBody
    public Tarefa createTarefa(@RequestBody Tarefa tarefa) {
        try{
            tarefaService.createTarefa(tarefa);
            return tarefa;
        }catch(Error error){
            System.out.println(error);
            return null;
        }
    }
    @DeleteMapping("/deleteTarefa")
    @ResponseBody
    public Tarefa deleteTarefa(@RequestParam String id){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA"+ id);
        try{
            Tarefa tarefaDeletada = tarefaService.deleteTarefa(Long.valueOf(id));
            return tarefaDeletada;
        }
        catch(Error error){
            System.out.println(error);
            return null;
        }
    }

    
}
