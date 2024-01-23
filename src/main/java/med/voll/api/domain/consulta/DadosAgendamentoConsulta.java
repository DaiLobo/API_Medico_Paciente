package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Long idMedico,
        @NotNull
        Long idPaciente,

        @NotNull
        @Future // Não permitir datas passadas
        LocalDateTime data,

        Especialidade especialidade

//        @NotNull
//        @Future
//        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
//        LocalDateTime data
) {
}
