package br.com.wzzy.biblioteca.mapper;

import br.com.wzzy.biblioteca.dto.LivroDTO;
import br.com.wzzy.biblioteca.model.entity.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LivroMapper {

    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    @Mapping(source = "idLivro", target = "idLivroDTO")
    @Mapping(source = "dadosLivro.idDadosLivros", target = "dadosLivroDTO.idDadosLivroDTO")
    @Mapping(source = "dadosLivro.titulo", target = "dadosLivroDTO.tituloDTO")
    @Mapping(source = "dadosLivro.autor", target = "dadosLivroDTO.autorDTO")
    @Mapping(source = "dadosLivro.ISBN", target = "dadosLivroDTO.ISBNDTO")
    @Mapping(source = "dadosLivro.editora", target = "dadosLivroDTO.editoraDTO")
    @Mapping(source = "dadosLivro.ano", target = "dadosLivroDTO.anoDTO")
    @Mapping(source = "dadosLivro.categoria", target = "dadosLivroDTO.categoriaLivroEnumDTO")
    @Mapping(source = "dadosLivro.status", target = "dadosLivroDTO.statusLivroEnumDTO")
    LivroDTO paraLivroDTO(Livro cliente);

    @Mapping(source = "idLivroDTO", target = "idLivro")
    @Mapping(source = "dadosLivroDTO.idDadosLivroDTO", target = "dadosLivro.idDadosLivros")
    @Mapping(source = "dadosLivroDTO.tituloDTO", target = "dadosLivro.titulo")
    @Mapping(source = "dadosLivroDTO.autorDTO", target = "dadosLivro.autor")
    @Mapping(source = "dadosLivroDTO.ISBNDTO", target = "dadosLivro.ISBN")
    @Mapping(source = "dadosLivroDTO.editoraDTO", target = "dadosLivro.editora")
    @Mapping(source = "dadosLivroDTO.anoDTO", target = "dadosLivro.ano")
    @Mapping(source = "dadosLivroDTO.categoriaLivroEnumDTO", target = "dadosLivro.categoria")
    @Mapping(source = "dadosLivroDTO.statusLivroEnumDTO", target = "dadosLivro.status")
    Livro paraLivro(LivroDTO cliente);
}