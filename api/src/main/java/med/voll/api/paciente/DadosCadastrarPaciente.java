package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.models.DadosEndereco;

public record DadosCadastrarPaciente(@NotBlank
                                     String nome,

                                     @NotBlank
                                     @Email
                                     String email,

                                     @NotBlank
                                     String telefone,

                                     @NotNull
                                     Plano plano,

                                     @NotNull
                                     @Valid
                                     DadosEndereco endereco) {
}