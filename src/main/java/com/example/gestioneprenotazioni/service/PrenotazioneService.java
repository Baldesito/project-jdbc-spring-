package com.example.gestioneprenotazioni.service;

import com.example.gestioneprenotazioni.model.Prenotazione;
import com.example.gestioneprenotazioni.repository.PrenotazioneDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneDAORepository prenotazioneRepository;

    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {
        // Verifica se l'utente ha già una prenotazione per la stessa data
        boolean esistePrenotazioneUtente = prenotazioneRepository.existsByUtenteAndData(
                prenotazione.getUtente(), prenotazione.getData());

        if (esistePrenotazioneUtente) {
            throw new IllegalStateException("L'utente ha già una prenotazione per questa data.");
        }

        // Verifica se la postazione è già prenotata per quella data
        boolean esistePrenotazionePostazione = prenotazioneRepository.existsByPostazioneAndData(
                prenotazione.getPostazione(), prenotazione.getData());

        if (esistePrenotazionePostazione) {
            throw new IllegalStateException("La postazione è già prenotata per questa data.");
        }

        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public Optional<Prenotazione> getPrenotazioneById(Long id) {
        return prenotazioneRepository.findById(id);
    }

    public Prenotazione savePrenotazione(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public void deletePrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}
