package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

// DTO: Data Transfer Object é usado para transferir dados.
/* Ou receber os dados ou enviar dados. Para não enviar uma entidade inteira
   Pode usar isso para selecionar só as informações necessárias.
* */
// Record é uma forma de criar uma classe só com atributos.
public record DadosCadastroPacientes(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{11}$")
        String cpf,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
