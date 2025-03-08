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
@Table(name = "tipo_pessoa")
public class TipoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPessoa;
    private String descricao;
}
