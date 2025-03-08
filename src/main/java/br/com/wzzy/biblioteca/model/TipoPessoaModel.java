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
@Table(name = "usuario")
public class TipoPessoaModel {

    @Id
    private Long idTipoUsuario;

    private String tipoUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_model_id_contato")
    private ContatoModel contatoModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_pessoais_model_id_dados_pessoais")
    private DadosPessoaisModel dadosPessoaisModel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_model_id_endereco")
    private EnderecoModel enderecoModel;
}
