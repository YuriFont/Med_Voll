package med.voll.api.paciente;

import med.voll.api.medico.Especialidade;

public record DadosListagemPaciente(Long id,
                                    String nome,
                                    String email,
                                    String telefone,
                                    Plano plano) {
    public DadosListagemPaciente(Paciente p) {
        this(p.getId(), p.getNome(), p.getEmail(), p.getTelefone(), p.getPlano());
    }
}
