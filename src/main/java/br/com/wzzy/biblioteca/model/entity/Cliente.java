package br.com.wzzy.biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_pessoais_idDadosPessoais")
    private DadosPessoais dadosPessoais;
}
