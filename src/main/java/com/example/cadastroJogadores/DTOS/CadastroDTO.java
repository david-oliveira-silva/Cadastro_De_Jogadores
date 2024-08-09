package com.example.cadastroJogadores.DTOS;

import com.example.cadastroJogadores.Enum.Grupo;

public record CadastroDTO(


        String nome,
        String codiNome,

        String email,

        Grupo grupo
) {
}
