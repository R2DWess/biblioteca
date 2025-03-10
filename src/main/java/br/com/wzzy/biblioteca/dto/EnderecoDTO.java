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

    private Long idEnderecoDTO;
    private String ruaDTO;
    private String bairroDTO;
    private String cidadeDTO;
    private String estadoDTO;
    private String paisDTO;
    private String cepDTO;
}
