package com.aula.desc.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_instrutor")
public class Instrutor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInstrutor;
    private Integer RG;

    @Column(length = 45)
    private String nome;

    private LocalDate nascimento;
    private Integer titulacao;

    @OneToMany(mappedBy = "instrutor")
    private List<Turma> turmas = new ArrayList<>();

    public  Instrutor(){
    }

    public Instrutor(Integer idInstrutor, Integer RG, String nome, LocalDate nascimento, Integer titulacao) {
        this.idInstrutor = idInstrutor;
        this.RG = RG;
        this.nome = nome;
        this.nascimento = nascimento;
        this.titulacao = titulacao;
    }

    public Integer getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(Integer idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public Integer getRG() {
        return RG;
    }

    public void setRG(Integer RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(Integer titulacao) {
        this.titulacao = titulacao;
    }
}
