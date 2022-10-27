package com.lucas.taskmanager.repository;
import org.springframework.stereotype.Repository;
import com.lucas.taskmanager.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long>{
}
