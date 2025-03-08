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
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @ManyToOne
    @JoinColumn(name = "cliente_idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_idCliente")
    private Funcionario funcionario;
}
