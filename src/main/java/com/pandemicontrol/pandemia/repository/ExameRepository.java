package com.pandemicontrol.pandemia.repository;

import com.pandemicontrol.pandemia.entity.Exame;
import com.pandemicontrol.pandemia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long> {
    Optional<Exame> findByAtendimentoHash(String atendimentoHash);
}
