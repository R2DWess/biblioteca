package br.com.wzzy.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long idFuncionario;
    private DadosPessoaisDTO dadosPessoaisDTO;
}
