package br.com.wzzy.biblioteca.model.entity;

import br.com.wzzy.biblioteca.model.enums.CategoriaLivroEnum;
import br.com.wzzy.biblioteca.model.enums.StatusLivroEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dados_livro")
public class DadosLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDadosLivros;
    private String titulo;
    private String autor;
    private String ISBN;
    private String editora;
    private String ano;
    @Enumerated(EnumType.STRING)
    private CategoriaLivroEnum categoria;
    @Enumerated(EnumType.STRING)
    private StatusLivroEnum status;
}
