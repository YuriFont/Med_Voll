package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;


public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT m FROM Medico m
            WHERE
            m.ativo = 1
            and
            m.especialidade = :especialidade
            and
            m.id NOT in(
                SELECT c.medico.id FROM Consulta c
                WHERE
                c.data = :data
            )
            ORDER BY rand()
            LIMIT 1
            """)
    Medico escolherMedicoAleatorio(Especialidade especialidade, LocalDateTime data);
}
