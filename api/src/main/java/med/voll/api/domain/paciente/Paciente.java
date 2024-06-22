package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    @Enumerated(EnumType.STRING)
    private Plano plano;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastrarPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.plano = dados.plano();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizarPaciente p) {
        if (p.nome() != null)
            this.nome = p.nome();
        if (p.telefone() != null)
            this.telefone = p.telefone();
        if (p.endereco() != null)
            this.endereco.atualizarInformacoes(p.endereco());
    }

    public void excluir() {
        this.ativo = false;
    }
}
