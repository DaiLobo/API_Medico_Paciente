package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamentoConsulta {
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        // Pegar o dia da semana
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAbertura = dataConsulta.getHour() < 7;
        var depoisEncerramento = dataConsulta.getHour() > 18;

        if (domingo || antesAbertura || depoisEncerramento) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}
