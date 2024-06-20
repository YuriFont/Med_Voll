package med.voll.api.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedico(@NotNull Long id,
                                   String nome,
                                   String telefone,
                                   DadosEndereco endereco) {
}
