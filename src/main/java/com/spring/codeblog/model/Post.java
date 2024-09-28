package com.spring.codeblog.model;

import lombok.Getter;
import lombok.Setter;



import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

//Entity e Table é definir que vai ser um model e uma tabela no banco
@Getter
@Setter
@Entity
@Table(name="TB_POST")

public class Post {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //gerar automaticamente o id
    private Long id;

    @NotBlank  //pra ser obrigatório por um titulo 
    private String titulo;

    @NotBlank
    private String autor;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate data;

    @NotBlank
    @Lob
    private String texto;



    public Post(Long id, String titulo, String autor, LocalDate data, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.texto = texto;
    }

    public Post(){}

 

}
