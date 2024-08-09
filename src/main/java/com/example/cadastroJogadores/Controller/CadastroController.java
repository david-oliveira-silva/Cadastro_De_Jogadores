package com.example.cadastroJogadores.Controller;

import com.example.cadastroJogadores.DTOS.CadastroDTO;
import com.example.cadastroJogadores.DTOS.UpdateDTO;
import com.example.cadastroJogadores.Entity.Cadastro;
import com.example.cadastroJogadores.Repository.CadastroRepository;
import com.example.cadastroJogadores.Services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CadastroController {
    @Autowired
    CadastroService cadastroService;

    @Autowired
    CadastroRepository cadastroRepository;

    @PostMapping("/cadastro")
    public ResponseEntity <?> cadastro(@RequestBody CadastroDTO cadastroDTO){

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroService.CadastroJogador(cadastroDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<?>GetCadastro(){
        cadastroService.ListarTodosJogador();
        return ResponseEntity.ok().body(cadastroService.ListarTodosJogador());

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> GetCadastroID(@PathVariable(name = "id")Long id){
        Optional<Cadastro> cadastro0 = cadastroRepository.findById(id);

        if (cadastro0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario com o Id: " + id +  " não foi encontrado");

        }
        cadastroService.ListarJogadorPorID(id);
        return ResponseEntity.ok().body(cadastroService.ListarJogadorPorID(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateCadastro(@RequestBody UpdateDTO updateDTO,@PathVariable(name = "id")Long id){
        Optional<Cadastro> cadastro0 = cadastroRepository.findById(id);

        if (cadastro0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario com o Id: " + id +  " não foi encontrado");

        }
        cadastroService.UpdateJogador(updateDTO,id);
        return ResponseEntity.ok().body("Usuario com o Id: " + id +  " atualizado");

    }
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> DeleteCadastro(@PathVariable(name = "id") Long id){
        Optional<Cadastro> cadastro0 = cadastroRepository.findById(id);

        if (cadastro0.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario com o Id: " + id +  " não foi encontrado");

        }
        cadastroService.deleteJogador(id);
        return ResponseEntity.ok().body("Usuario com o Id: " + id +  " Deletado");
    }



}
