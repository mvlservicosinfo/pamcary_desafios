package br.com.dominio.apirestpessoaa.Repositories;


import br.com.dominio.apirestpessoaa.Model.Model_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPessoas extends JpaRepository<Model_Pessoa,Long> {
}
