package br.com.wzzy.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    private Long idLivroDTO;
    private DadosLivroDTO dadosLivroDTO;

}
