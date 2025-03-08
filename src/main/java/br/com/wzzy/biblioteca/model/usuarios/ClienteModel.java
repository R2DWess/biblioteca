package br.com.wzzy.biblioteca.model.usuarios;

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
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dados_pessoais_model_id_dados_pessoais")
    private DadosPessoaisModel dadosPessoaisModel;
}
