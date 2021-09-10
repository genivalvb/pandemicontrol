package com.pandemicontrol.pandemia.repository;

import com.pandemicontrol.pandemia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNameHash(String nameHash);
}
