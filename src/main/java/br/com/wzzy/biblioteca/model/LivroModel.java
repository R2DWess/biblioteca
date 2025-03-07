package br.com.wzzy.biblioteca.model;

import br.com.wzzy.biblioteca.model.enums.CategoriaLivroEnum;
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
@Table(name = "livro")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;
    private String tituloLivro;
    private String autor;
    private String categoria;
    private String status;

}
