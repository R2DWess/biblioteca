package br.com.wzzy.biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dados_pessoais")
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDadosPessoais;
    private String nome;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_idContato")
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_idEndereco")
    private Endereco endereco;

}
