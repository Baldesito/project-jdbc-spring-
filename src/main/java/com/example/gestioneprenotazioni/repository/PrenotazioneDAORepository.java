package com.example.gestioneprenotazioni.repository;

import com.example.gestioneprenotazioni.model.Prenotazione;
import com.example.gestioneprenotazioni.model.Utente;
import com.example.gestioneprenotazioni.model.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PrenotazioneDAORepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByUtenteAndData(Utente utente, LocalDate data);
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);
}
