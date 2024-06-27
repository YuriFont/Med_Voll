package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime data = dados.data();
        boolean dataDomingo = data.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean antesDaAbertura = (data.getHour() < 7);
        boolean depoisDoFechamento = (data.getHour() > 18);

        if (dataDomingo || antesDaAbertura || depoisDoFechamento)
            throw new ValidacaoException("Consulta fora do dia ou horário de funcionamenteo!!!");
    }

}
