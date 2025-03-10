package br.com.wzzy.biblioteca.dto;

import br.com.wzzy.biblioteca.model.enums.CategoriaLivroEnum;
import br.com.wzzy.biblioteca.model.enums.StatusLivroEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosLivroDTO {

    private Long idDadosLivroDTO;

    @NotBlank(message = "O autor não pode estar em branco")
    private String tituloDTO;
    @NotBlank(message = "O titulo não pode estar em branco")
    private String autorDTO;
    @NotBlank(message = "O ISBN do livro não pode ser nulo")
    private String ISBNDTO;
    @NotBlank(message = "A editora do livro não pode ser nula")
    private String editoraDTO;
    @NotBlank(message = "O ano do livro não pode ser nula")
    private String anoDTO;
    @NotNull(message = "A categoria do livro não pode ser nula")
    private CategoriaLivroEnum categoriaLivroEnumDTO;
    @NotBlank(message = "O status do livro não pode ser nulo")
    private StatusLivroEnum statusLivroEnumDTO;
}
