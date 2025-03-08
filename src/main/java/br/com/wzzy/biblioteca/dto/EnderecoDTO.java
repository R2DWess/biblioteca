package br.com.wzzy.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long idEndereco;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
}
