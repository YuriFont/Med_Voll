package med.voll.api.domain.paciente;

public record DadosListagemPaciente(Long id,
                                    String nome,
                                    String email,
                                    String telefone,
                                    Plano plano) {
    public DadosListagemPaciente(Paciente p) {
        this(p.getId(), p.getNome(), p.getEmail(), p.getTelefone(), p.getPlano());
    }
}
