package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.domain.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Avisa para spring que é uma classe que vai tratar erros da API.
@RestControllerAdvice
public class TratadorDeErros {

    // Se for lançada, em qualquer controller, uma exception not found ele irá chamar esse método.
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        // ResponseEntity: Representa todas as respostas HTTP, incluindo corpo, cabeçalho e status.
        // build: Cria e retorna a instância final de ResponseEntity com as configurações definidas.
        return ResponseEntity.notFound().build();
    }

    // Trata a exceção de campos inválidos
    // Pegar a exception com (MethodArgumentNotValidException exception)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratarErroRegraNegocio(ValidacaoException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
