package br.com.wzzy.biblioteca.dto;

import br.com.wzzy.biblioteca.model.entity.DadosPessoais;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long idCliente;
    private DadosPessoaisDTO dadosPessoaisDTO;

}
