package com.lucas.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tarefa {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment Id
    private Long id;
    private String nome;
    private String descricao;
    private String data;
    private String status;

}
