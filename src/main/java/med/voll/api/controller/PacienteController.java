package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

//Usado para marcar uma classe como um controller no padrão MVC.
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
