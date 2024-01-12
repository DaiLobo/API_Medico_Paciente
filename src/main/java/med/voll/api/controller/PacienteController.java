package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

//Usado para marcar uma classe como um controller no padrão MVC. Api REST
@RestController
//Especifica a URL que um método do controlador irá manipular. Endpoint.
@RequestMapping("pacientes")
public class PacienteController {

    /*
    Utilizado para injetar depedências automaticamente em uma classe, permitindo
    que você obtenha uma instância de uma classe necessária sem criar manualmente.
    */
    @Autowired
    private PacienteRepository repository;

    /*RequesteBody: Usada para injetar o body de uma requisição nos parâmetros
    do método do controller que doi chamado para tratar essa requisição
    */
    //Valid: Valida se o body está no formato correto
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPacientes dados) {
        repository.save(new Paciente((dados)));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable pag) {
        return repository.findAllByAtivoTrue(pag).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }
}
