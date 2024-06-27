package med.voll.api.domain.consulta.validacoes_cancelamento;

import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.consulta.validacoes_agendamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidarMotivoDoCancelamento implements ValidadorCancelamentoDeConsulta {

    public void validar(DadosCancelamentoConsulta dados) {
        if (!dados.motivo().equalsIgnoreCase("paciente desistiu") && !dados.motivo().equalsIgnoreCase("médico desistiu"))
            throw new ValidacaoException("Esse motivo não pode ser aceito!!!");
    }

}
