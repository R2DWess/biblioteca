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
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_livro_idDadosLivro")
    private DadosLivro dadosLivro;
}
