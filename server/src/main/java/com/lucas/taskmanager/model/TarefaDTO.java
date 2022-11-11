package com.lucas.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TarefaDTO {
    @JsonIgnore
    private long id;
    private String nome;
    private String descricao;
    private String data;
    private String status;
}
