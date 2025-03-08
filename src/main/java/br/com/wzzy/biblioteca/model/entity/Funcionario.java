package br.com.wzzy.biblioteca.model.entity;

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
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_pessoais_id")
    private DadosPessoais dadosPessoais;
}
