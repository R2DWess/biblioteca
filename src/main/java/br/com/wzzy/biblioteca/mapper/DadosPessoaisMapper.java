package br.com.wzzy.biblioteca.mapper;

import br.com.wzzy.biblioteca.dto.DadosPessoaisDTO;
import br.com.wzzy.biblioteca.model.entity.DadosPessoais;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DadosPessoaisMapper {

    DadosPessoaisMapper INSTANCE = Mappers.getMapper(DadosPessoaisMapper.class);

    @Mapping(source = "idDadosPessoais", target = "idDadosPesoaisDTO")
    @Mapping(source = "nome", target = "nomeDTO")
    @Mapping(source = "cpf", target = "cpfDTO")
    @Mapping(source = "contato.idContato", target = "contatoDTO.idContatoDTO")
    @Mapping(source = "contato.telefone", target = "contatoDTO.telefoneDTO")
    @Mapping(source = "contato.email", target = "contatoDTO.emailDTO")
    @Mapping(source = "endereco.idEndereco", target = "enderecoDTO.idEnderecoDTO")
    @Mapping(source = "endereco.rua", target = "enderecoDTO.ruaDTO")
    @Mapping(source = "endereco.bairro", target = "enderecoDTO.bairroDTO")
    @Mapping(source = "endereco.cidade", target = "enderecoDTO.cidadeDTO")
    @Mapping(source = "endereco.estado", target = "enderecoDTO.estadoDTO")
    @Mapping(source = "endereco.pais", target = "enderecoDTO.paisDTO")
    @Mapping(source = "endereco.cep", target = "enderecoDTO.cepDTO")
    DadosPessoaisDTO paraDadosPessoaisDTO(DadosPessoais dadosPessoais);

    @Mapping(source = "idDadosPesoaisDTO", target = "idDadosPessoais")
    @Mapping(source = "nomeDTO", target = "nome")
    @Mapping(source = "cpfDTO", target = "cpf")
    @Mapping(source = "contatoDTO.idContatoDTO", target = "contato.idContato")
    @Mapping(source = "contatoDTO.telefoneDTO", target = "contato.telefone")
    @Mapping(source = "contatoDTO.emailDTO", target = "contato.email")
    @Mapping(source = "enderecoDTO.idEnderecoDTO", target = "endereco.idEndereco")
    @Mapping(source = "enderecoDTO.ruaDTO", target = "endereco.rua")
    @Mapping(source = "enderecoDTO.bairroDTO", target = "endereco.bairro")
    @Mapping(source = "enderecoDTO.cidadeDTO", target = "endereco.cidade")
    @Mapping(source = "enderecoDTO.estadoDTO", target = "endereco.estado")
    @Mapping(source = "enderecoDTO.paisDTO", target = "endereco.pais")
    @Mapping(source = "enderecoDTO.cepDTO", target = "endereco.cep")
    DadosPessoais paraDadosPessoais(DadosPessoaisDTO dadosPessoaisDTO);
}