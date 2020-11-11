package br.salaoeveris.app.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.salaoeveris.app.model.*;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
	Optional<Agendamento> findById(Long id);
	
	List<Agendamento> findByDataInicio(Agendamento dataHora);
	List<Agendamento> findByDataFinal(Agendamento dataHora);
	
	 @Query(value = "EXEC SP_PESQUISA :dataInicio, :dataFinal", nativeQuery = true)
	  List<Agendamento> findPesquisa(@Param("dataInicio") Date dataInicio, @Param("dataFinal") Date dataFinal);

}
