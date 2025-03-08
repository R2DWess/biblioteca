package br.com.wzzy.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {

    private Long idDadosPesoais;
    private String nome;
    private String cpf;
    private ContatoDTO contatoDTO;
    private EnderecoDTO enderecoDTO;

}
