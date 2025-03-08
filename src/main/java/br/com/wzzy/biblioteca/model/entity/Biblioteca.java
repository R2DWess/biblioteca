package br.com.wzzy.biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "biblioteca")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBiblioteca;

    @ManyToOne
    @JoinColumn(name = "usuario_idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_idLivro")
    private Livro livro;
}
