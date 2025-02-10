package com.example.gestioneprenotazioni.repository;

import com.example.gestioneprenotazioni.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioDAORepository extends JpaRepository<Edificio, Long> {
}
