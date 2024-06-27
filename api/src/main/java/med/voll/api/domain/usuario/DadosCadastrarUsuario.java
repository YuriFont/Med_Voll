package med.voll.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarUsuario(@NotBlank String login, @NotBlank String senha) {

    public DadosCadastrarUsuario(Usuario u) {
        this(u.getLogin(), u.getSenha());
    }

}
