package com.example.cadastroJogadores.DTOS;

import com.example.cadastroJogadores.Enum.Grupo;

public record UpdateDTO(

        String nome,
        Grupo grupo,

        String email,

        String codiNome
) {

}
