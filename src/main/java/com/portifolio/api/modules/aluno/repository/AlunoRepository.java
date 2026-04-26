package com.portifolio.api.modules.aluno.repository;

import com.portifolio.api.modules.aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByCpf(String cpf);

    List<Aluno> findByNomeCompletoContainingIgnoreCase(String nomeCompleto);
}
