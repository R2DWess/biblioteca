package br.com.wzzy.biblioteca.model;

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
public class DadosPessoaisModel {

    @Id
    private Long idDadosPessoais;
    private String nome;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_model_id_contato")
    private ContatoModel contatoModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_model_id_endereco")
    private EnderecoModel enderecoModel;

}
