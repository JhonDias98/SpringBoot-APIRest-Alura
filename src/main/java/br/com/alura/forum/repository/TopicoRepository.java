package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	//A classe Topico tem um relacionamento com a classe Curso
	//Após o underline é passado o atributo da classe que queremos da classe Curso 
	List<Topico> findByCurso_Nome(String nomeCurso);

	//Usando @Query para escrevermos nossa propria query
	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	//Usando @Param para referenciar o parâmetro da query
	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
	
}