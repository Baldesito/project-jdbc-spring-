package com.example.gestioneprenotazioni.repository;

import com.example.gestioneprenotazioni.model.Prenotazione;
import com.example.gestioneprenotazioni.model.Utente;
import com.example.gestioneprenotazioni.model.Postazione;
import com.example.gestioneprenotazioni.model.Edificio;
import com.example.gestioneprenotazioni.Enumeration.TipoPostazione;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
public class PrenotazioneDAORepositoryTest {

    @Autowired
    private PrenotazioneDAORepository prenotazioneRepository;

    @Autowired
    private UtenteDAORepository utenteRepository;

    @Autowired
    private PostazioneDAORepository postazioneRepository;

    @Autowired
    private EdificioDAORepository edificioRepository;

    @Test
    public void testSaveAndFindById() {
        // Creiamo e salviamo un Edificio
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio Test");
        edificio.setIndirizzo("Via Test, 123");
        edificio.setCitta("Milano");
        Edificio savedEdificio = edificioRepository.save(edificio);

        // Creiamo e salviamo un Utente
        Utente utente = new Utente();
        utente.setUsername("testuser");
        utente.setNomeCompleto("Test User");
        utente.setEmail("test.user@example.com");
        Utente savedUtente = utenteRepository.save(utente);

        // Creiamo e salviamo una Postazione
        Postazione postazione = new Postazione();
        postazione.setCodice("P12345");
        postazione.setDescrizione("Postazione di test");
        postazione.setTipo(TipoPostazione.PRIVATO);
        postazione.setNumeroMassimoOccupanti(4);
        postazione.setEdificio(savedEdificio); // Associazione corretta
        Postazione savedPostazione = postazioneRepository.save(postazione);

        // Creiamo e salviamo una Prenotazione
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(savedUtente);
        prenotazione.setPostazione(savedPostazione);
        prenotazione.setData(LocalDate.now());
        Prenotazione savedPrenotazione = prenotazioneRepository.save(prenotazione);

        // Recuperiamo la prenotazione dal database e verifichiamo
        Prenotazione foundPrenotazione = prenotazioneRepository.findById(savedPrenotazione.getId()).orElse(null);

        assertNotNull(foundPrenotazione, "La prenotazione con ID " + savedPrenotazione.getId() + " dovrebbe esistere");
        assertEquals(savedPrenotazione.getUtente().getUsername(), foundPrenotazione.getUtente().getUsername());
        assertEquals(savedPrenotazione.getPostazione().getCodice(), foundPrenotazione.getPostazione().getCodice());
        assertEquals(savedPrenotazione.getData(), foundPrenotazione.getData());
    }
}
