package com.lucas.taskmanager.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TarefaDTO {
    private long id;
    private String nome;
    private String descricao;
    private String data;
    private String status;
}
