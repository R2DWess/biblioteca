package br.com.wzzy.biblioteca.model;

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
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "cliente_model_id_cliente")
    private ClienteModel clienteModel;

    @ManyToOne
    @JoinColumn(name = "funcionario_model_id_funcionario")
    private FuncionarioModel funcionarioModel;
}
