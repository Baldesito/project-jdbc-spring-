package com.example.gestioneprenotazioni.repository;

import com.example.gestioneprenotazioni.model.Postazione;
import com.example.gestioneprenotazioni.Enumeration.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneDAORepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}
