package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(@NotNull Long id,
                                   String nome,
                                   String telefone,
                                   DadosEndereco endereco) {
}
