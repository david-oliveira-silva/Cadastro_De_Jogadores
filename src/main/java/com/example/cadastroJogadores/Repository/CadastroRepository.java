package com.example.cadastroJogadores.Repository;

import com.example.cadastroJogadores.Entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository  extends JpaRepository<Cadastro,Long> {
}
