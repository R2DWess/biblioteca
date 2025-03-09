package br.com.wzzy.biblioteca.mapper;

import br.com.wzzy.biblioteca.dto.LivroDTO;
import br.com.wzzy.biblioteca.model.entity.Livro;

public class LivroMapper {

    public static Livro paraEntidadeLivro(LivroDTO livroDTO) {
        if (livroDTO == null ) return null;

        Livro livro = new Livro();
        livro.setAutor(livroDTO.getAutor());
        livro.setIdLivro(livroDTO.getIdLivro());
        livro.setTitulo(livroDTO.getTitulo());
        livro.setStatusLivroEnum(livroDTO.getStatusLivroEnum());
        livro.setCategoriaLivroEnum(livroDTO.getCategoriaLivroEnum());

        return livro;
    }

    public static LivroDTO paraLivroDTO(Livro livro) {
        if(livro == null) return null;

        return new LivroDTO(
                livro.getIdLivro(),
                livro.getAutor(),
                livro.getTitulo(),
                livro.getCategoriaLivroEnum(),
                livro.getStatusLivroEnum());

    }
}
