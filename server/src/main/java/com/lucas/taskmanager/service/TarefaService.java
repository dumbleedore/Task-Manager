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
    public Tarefa deleteTarefa(Long id){
        Tarefa tarefa = tarefaRepository.findById(id).get();
        tarefaRepository.deleteById(id);
        return tarefa;
    }
    public List <Tarefa> getAllTarefas(){
        return tarefaRepository.findAll();
    }
    public Tarefa updateTarefa(Long id, Tarefa tarefa){
        Tarefa tarefaAtualizada = tarefaRepository.findById(id).get();
        tarefaAtualizada.setNome(tarefa.getNome());
        tarefaAtualizada.setDescricao(tarefa.getDescricao());
        tarefaAtualizada.setData(tarefa.getData());
        tarefaAtualizada.setStatus(tarefa.getStatus());
        tarefaRepository.save(tarefaAtualizada);
        return tarefaAtualizada;
    }
}
