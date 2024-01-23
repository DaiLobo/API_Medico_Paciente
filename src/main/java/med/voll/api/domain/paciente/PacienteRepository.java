package med.voll.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//São classes usadas para fazer consultar e inserção de dados nas tabelas do db.
//Separa a lógica de negócios da lógica de acesso a dados.
//JPARepository cria todos os métodos em runtime. Passa entidade e tipo do id.
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable pag);

    @Query("""
            select p.ativo from Paciente p
            where p.id = :id
            """)
    Boolean findAtivoById(Long id);
}
