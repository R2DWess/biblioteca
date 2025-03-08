package br.com.wzzy.biblioteca.dto;

import br.com.wzzy.biblioteca.model.enums.CategoriaLivroEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    private Long idLivro;
    private String titulo;
    private String categoria;
    private String autor;
    private CategoriaLivroEnum categoriaLivroEnum;
}
