package br.com.wzzy.biblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaisDTO {

    private Long idDadosPesoaisDTO;
    @NotBlank(message = "O campo nome deve ser informado corretamente!")
    private String nomeDTO;
    @CPF(message = "O cpf nome deve ser informado corretamente!")
    private String cpfDTO;
    private ContatoDTO contatoDTO;
    private EnderecoDTO enderecoDTO;

}
