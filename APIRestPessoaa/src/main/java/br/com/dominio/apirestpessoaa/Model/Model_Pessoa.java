package br.com.dominio.apirestpessoaa.Model;


import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@Table(name="Pessoas")
@Entity
public class Model_Pessoa {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "uf", nullable = false)
    private char uf;
}
