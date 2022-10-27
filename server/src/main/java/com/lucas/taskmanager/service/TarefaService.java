package com.lucas.taskmanager.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucas.taskmanager.model.Tarefa;
import com.lucas.taskmanager.repository.TarefaRepository;
import java.util.List;
@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;
    public List<Tarefa> getTarefas(){
        return tarefaRepository.findAll();
    }
    public Tarefa createTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }
}
