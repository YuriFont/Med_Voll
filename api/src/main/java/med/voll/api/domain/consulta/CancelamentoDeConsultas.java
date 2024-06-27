package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validacoes_agendamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelamentoDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorCancelamentoDeConsulta> validadores;

    public DadosDetalhamentoConsulta cancelar(DadosCancelamentoConsulta dados) {
        if (!consultaRepository.existsById(dados.idConsulta()))
            throw new ValidacaoException("Essa consulta não existe!!!");

        validadores.forEach(v -> v.validar(dados));

        Consulta consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consultaRepository.deleteById(dados.idConsulta());
        return new DadosDetalhamentoConsulta(consulta);
    }

}
