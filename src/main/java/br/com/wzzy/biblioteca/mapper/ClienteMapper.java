package br.com.wzzy.biblioteca.mapper;

import br.com.wzzy.biblioteca.dto.ClienteDTO;
import br.com.wzzy.biblioteca.model.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "idClienteDTO", target = "idCliente")
    @Mapping(source = "dadosPessoaisDTO.idDadosPesoaisDTO", target = "dadosPessoais.idDadosPessoais")
    @Mapping(source = "dadosPessoaisDTO.nomeDTO", target = "dadosPessoais.nome")
    @Mapping(source = "dadosPessoaisDTO.cpfDTO", target = "dadosPessoais.cpf")
    @Mapping(source = "dadosPessoaisDTO.contatoDTO.idContatoDTO", target = "dadosPessoais.contato.idContato")
    @Mapping(source = "dadosPessoaisDTO.contatoDTO.emailDTO", target = "dadosPessoais.contato.email")
    @Mapping(source = "dadosPessoaisDTO.contatoDTO.telefoneDTO", target = "dadosPessoais.contato.telefone")
    @Mapping(source = "dadosPessoaisDTO.enderecoDTO.idEnderecoDTO", target = "dadosPessoais.endereco.idEndereco")
    @Mapping(source = "dadosPessoaisDTO.enderecoDTO.ruaDTO", target = "dadosPessoais.endereco.rua")
    @Mapping(source = "dadosPessoaisDTO.enderecoDTO.bairroDTO", target = "dadosPessoais.endereco.bairro")
    @Mapping(source = "dadosPessoaisDTO.enderecoDTO.cidadeDTO", target = "dadosPessoais.endereco.cidade")
    @Mapping(source = "dadosPessoaisDTO.enderecoDTO.estadoDTO", target = "dadosPessoais.endereco.estado")
    @Mapping(source = "dadosPessoaisDTO.enderecoDTO.paisDTO", target = "dadosPessoais.endereco.pais")
    @Mapping(source = "dadosPessoaisDTO.enderecoDTO.cepDTO", target = "dadosPessoais.endereco.cep")
    Cliente paraEntidadeCliente(ClienteDTO clienteDTO);

    @Mapping(source = "idCliente", target = "idClienteDTO")
    @Mapping(source = "dadosPessoais.idDadosPessoais", target = "dadosPessoaisDTO.idDadosPesoaisDTO")
    @Mapping(source = "dadosPessoais.nome", target = "dadosPessoaisDTO.nomeDTO")
    @Mapping(source = "dadosPessoais.cpf", target = "dadosPessoaisDTO.cpfDTO")
    @Mapping(source = "dadosPessoais.contato.idContato", target = "dadosPessoaisDTO.contatoDTO.idContatoDTO")
    @Mapping(source = "dadosPessoais.contato.email", target = "dadosPessoaisDTO.contatoDTO.emailDTO")
    @Mapping(source = "dadosPessoais.contato.telefone", target = "dadosPessoaisDTO.contatoDTO.telefoneDTO")
    @Mapping(source = "dadosPessoais.endereco.idEndereco", target = "dadosPessoaisDTO.enderecoDTO.idEnderecoDTO")
    @Mapping(source = "dadosPessoais.endereco.rua", target = "dadosPessoaisDTO.enderecoDTO.ruaDTO")
    @Mapping(source = "dadosPessoais.endereco.bairro", target = "dadosPessoaisDTO.enderecoDTO.bairroDTO")
    @Mapping(source = "dadosPessoais.endereco.cidade", target = "dadosPessoaisDTO.enderecoDTO.cidadeDTO")
    @Mapping(source = "dadosPessoais.endereco.estado", target = "dadosPessoaisDTO.enderecoDTO.estadoDTO")
    @Mapping(source = "dadosPessoais.endereco.pais", target = "dadosPessoaisDTO.enderecoDTO.paisDTO")
    @Mapping(source = "dadosPessoais.endereco.cep", target = "dadosPessoaisDTO.enderecoDTO.cepDTO")
    ClienteDTO paraClienteDTO(Cliente cliente);
}