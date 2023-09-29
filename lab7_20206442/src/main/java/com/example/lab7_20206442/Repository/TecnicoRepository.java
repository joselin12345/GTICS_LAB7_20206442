package com.example.lab7_20206442.Repository;

import com.example.lab7_20206442.Entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico , Integer> {
}
