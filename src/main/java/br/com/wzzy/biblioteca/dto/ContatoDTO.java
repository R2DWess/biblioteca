package br.com.wzzy.biblioteca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {

    private Long idContatoDTO;
    @Email(message = "O campo email deve ser informado corretamente: exmaple@email.com")
    private String emailDTO;
    @NotBlank(message = "O campo telefone deve ser informado corretamente: '61989911458'")
    private String telefoneDTO;

}
