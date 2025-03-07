package br.com.wzzy.biblioteca.model;

import br.com.wzzy.biblioteca.repository.LivroRepository;
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
@Table(name = "biblioteca")
public class BibliotecaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBiblioteca;

    @ManyToOne
    @JoinColumn(name = "usuario_model_id_usuario")
    private UsuarioModel usuarioModel;

    @ManyToOne
    @JoinColumn(name = "´livro_model_id_livro")
    private LivroModel livroModel;
}
