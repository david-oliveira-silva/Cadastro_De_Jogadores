package com.example.cadastroJogadores.Entity;

import com.example.cadastroJogadores.Enum.Grupo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "cadastros")
@Table(name = "cadastros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(unique = true)
    private String email;
    private String codiNome;

    private Grupo grupo;


    public Cadastro(String nome, String email, String codiNome, Grupo grupo) {

        this.nome = nome;
        this.email = email;
        this.codiNome = codiNome;
        this.grupo = grupo;
    }


}
