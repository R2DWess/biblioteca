package br.com.wzzy.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BibliotecaDTO {

    private Long idBiblioteca;
    private ClienteDTO clienteDTO;
    private LivroDTO livroDTO;
}
