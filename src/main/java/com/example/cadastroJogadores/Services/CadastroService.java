package com.example.cadastroJogadores.Services;

import com.example.cadastroJogadores.DTOS.CadastroDTO;
import com.example.cadastroJogadores.DTOS.UpdateDTO;
import com.example.cadastroJogadores.Entity.Cadastro;
import com.example.cadastroJogadores.Repository.CadastroRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {
    @Autowired
    CadastroRepository cadastroRepository;
    public Cadastro CadastroJogador(CadastroDTO cadastroDTO){
        var newJogador = new Cadastro(cadastroDTO.nome(),cadastroDTO.email(),cadastroDTO.codiNome(),cadastroDTO.grupo());
        return cadastroRepository.save(newJogador);

    }

    public List<Cadastro> ListarTodosJogador(){
       return cadastroRepository.findAll();
    }
    public Optional<Cadastro> ListarJogadorPorID(Long id){
        return cadastroRepository.findById(id);
    }

    public  Cadastro UpdateJogador(UpdateDTO updateDTO,Long id){
        Optional<Cadastro> cadastro0 = cadastroRepository.findById(id);
        var cadastroUpdate = cadastro0.get();
        BeanUtils.copyProperties(updateDTO,cadastroUpdate);
       return cadastroRepository.save(cadastroUpdate);
    }

    public void deleteJogador(Long id){
        Optional<Cadastro> cadastro0 = cadastroRepository.findById(id);
        if (cadastro0.isPresent()) {
            cadastroRepository.deleteById(id);
        }

    }

}
