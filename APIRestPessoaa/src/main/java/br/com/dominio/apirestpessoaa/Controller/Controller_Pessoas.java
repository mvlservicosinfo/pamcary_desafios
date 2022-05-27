package br.com.dominio.apirestpessoaa.Controller;


import br.com.dominio.apirestpessoaa.Model.Model_Pessoa;
import br.com.dominio.apirestpessoaa.Repositories.RepositoryPessoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class Controller_Pessoas {

    @Autowired
    private RepositoryPessoas repositoryPessoas;


    //Create
    @PostMapping(path="/criar")
     public void create(@RequestBody Model_Pessoa model_pessoa){
         repositoryPessoas.save(model_pessoa);
     }

     //Listar Todos
     @GetMapping(path="/listarTodos")
     public List<Model_Pessoa> listarTodos(){
        return repositoryPessoas.findAll();
     }

     //Listar por id
    @GetMapping(path="/listarPorId/{id}")
    public List<Model_Pessoa> listarPorId(@PathVariable Long id){
        return repositoryPessoas.findAll();
    }

    @DeleteMapping(path="/apagarPorId/{id}")
    public void apagar(@PathVariable Long id){
        repositoryPessoas.deleteById(id);
    }

    @PutMapping(path="Atualiza/{id}")
    public ResponseEntity<Model_Pessoa> atualizar(@PathVariable Long id, @Validated @RequestBody Model_Pessoa novo){
        Optional<Model_Pessoa> antigo = repositoryPessoas.findById(id);
        if(antigo.isPresent()){
            Model_Pessoa m = antigo.get();
            m.setNome(novo.getNome());
            m.setCidade((novo.getCidade()));
            m.setCep(novo.getCep());
            m.setUf(novo.getUf());
            repositoryPessoas.save(m);
            return new ResponseEntity<Model_Pessoa>(m, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
