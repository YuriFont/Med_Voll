package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agendaDeConsultas;

    @Autowired
    private CancelamentoDeConsultas cancelamentoDeConsultas;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        DadosDetalhamentoConsulta dadosDetalhamentoConsulta = agendaDeConsultas.agendar(dados);
        return ResponseEntity.ok(dadosDetalhamentoConsulta);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        DadosDetalhamentoConsulta dadosDetalhamentoConsulta = cancelamentoDeConsultas.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
