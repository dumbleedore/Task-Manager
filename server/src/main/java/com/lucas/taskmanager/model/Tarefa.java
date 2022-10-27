package com.lucas.taskmanager.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Tarefa {
    @Id // primary key
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO) // auto increment Id
    private long id;
    private String nome;
    private String descricao;
    private String data;
    private String status;
    
    public Tarefa(@JsonProperty("nome") String nome, 
    @JsonProperty("descricao") String descricao, 
    @JsonProperty("data") String data, 
    @JsonProperty("status") String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.status = status;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Tarefa [nome=" + nome + ", descricao=" + descricao + ", data=" + data + ", status=" + status + "]";
    }

}
