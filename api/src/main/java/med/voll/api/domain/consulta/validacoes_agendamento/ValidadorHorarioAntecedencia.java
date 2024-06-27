package med.voll.api.domain.consulta.validacoes_agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime data = dados.data();
        LocalDateTime agora =LocalDateTime.now();
        Long diferencaEmMinutos = Duration.between(agora, data).toMinutes();

        if (diferencaEmMinutos < 30)
            throw new ValidacaoException("A consulta deve ser marcada com antecedência da 30 minutos!!!");
    }

}
