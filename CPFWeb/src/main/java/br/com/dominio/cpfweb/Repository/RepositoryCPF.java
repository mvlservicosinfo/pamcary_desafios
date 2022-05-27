package br.com.dominio.cpfweb.Repository;

import br.com.dominio.cpfweb.Model.ModelCPF;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface RepositoryCPF extends JpaRepository<ModelCPF, Long> {
}
