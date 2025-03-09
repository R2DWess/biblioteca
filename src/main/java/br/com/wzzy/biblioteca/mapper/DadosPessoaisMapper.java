package br.com.wzzy.biblioteca.mapper;

import br.com.wzzy.biblioteca.dto.ContatoDTO;
import br.com.wzzy.biblioteca.dto.DadosPessoaisDTO;
import br.com.wzzy.biblioteca.dto.EnderecoDTO;
import br.com.wzzy.biblioteca.model.entity.Contato;
import br.com.wzzy.biblioteca.model.entity.DadosPessoais;
import br.com.wzzy.biblioteca.model.entity.Endereco;

public class DadosPessoaisMapper {

    public static DadosPessoais paraEntidadeDadosPessoais(DadosPessoaisDTO dadosPessoaisDTO) {
        if (dadosPessoaisDTO == null) return null;

        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setIdDadosPessoais(dadosPessoaisDTO.getIdDadosPesoais());
        dadosPessoais.setNome(dadosPessoaisDTO.getNome());
        dadosPessoais.setCpf(dadosPessoaisDTO.getCpf());
        dadosPessoais.setContato(paraEntidadeContato(dadosPessoaisDTO.getContatoDTO()));
        dadosPessoais.setEndereco(paraEntidadeEndereco(dadosPessoaisDTO.getEnderecoDTO()));
        return dadosPessoais;
    }

    public static Contato paraEntidadeContato(ContatoDTO contatoDTO){
        if (contatoDTO == null) return null;

        Contato contato = new Contato();
        contato.setIdContato(contatoDTO.getIdContato());
        contato.setEmail(contatoDTO.getEmail());
        contato.setTelefone(contatoDTO.getTelefone());

        return contato;
    }

    public static Endereco paraEntidadeEndereco(EnderecoDTO enderecoDTO){
        if (enderecoDTO == null) return null;

        Endereco endereco = new Endereco();
        endereco.setRua(enderecoDTO.getRua());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setPais(enderecoDTO.getPais());
        endereco.setCep(enderecoDTO.getCep());

        return endereco;
    }

    public static ContatoDTO paraContatoDTO(Contato contato) {
        if (contato == null) return null;

        return new ContatoDTO(
                contato.getIdContato(),
                contato.getEmail(),
                contato.getTelefone()
        );
    }

    public static EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        if (endereco == null) return null;

        return new EnderecoDTO(
                endereco.getIdEndereco(),
                endereco.getRua(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getPais(),
                endereco.getCep()
        );
    }

    public static DadosPessoaisDTO paraDadosPessoasiDTO(DadosPessoais dadosPessoais){
        if (dadosPessoais == null) return null;

        return new DadosPessoaisDTO(
                dadosPessoais.getIdDadosPessoais(),
                dadosPessoais.getNome(),
                dadosPessoais.getCpf(),
                paraContatoDTO(dadosPessoais.getContato()),
                paraEnderecoDTO(dadosPessoais.getEndereco()));

    }
}
