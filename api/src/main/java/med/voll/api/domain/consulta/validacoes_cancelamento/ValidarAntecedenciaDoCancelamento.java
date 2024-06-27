package med.voll.api.domain.consulta.validacoes_cancelamento;

import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.consulta.validacoes_agendamento.ValidadorCancelamentoDeConsulta;
import med.voll.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarAntecedenciaDoCancelamento implements ValidadorCancelamentoDeConsulta {

    public void validar(DadosCancelamentoConsulta dados) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime data = dados.data();
        Long diferencaEmHoras = Duration.between(agora, data).toHours();

        if (diferencaEmHoras < 24)
            throw new ValidacaoException("Não é permitido cancelamneto com menos de 24h antes da consulta!!!");
    }

}
