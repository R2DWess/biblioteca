package br.com.wzzy.biblioteca.dto;

import br.com.wzzy.biblioteca.model.entity.Cliente;
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
    private Cliente clienteDTO;
    private LivroDTO livroDTO;
}
