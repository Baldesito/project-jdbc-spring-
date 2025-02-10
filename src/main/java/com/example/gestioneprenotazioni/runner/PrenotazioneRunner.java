package com.example.gestioneprenotazioni.runner;

import com.example.gestioneprenotazioni.model.Prenotazione;
import com.example.gestioneprenotazioni.repository.PrenotazioneDAORepository;
import com.example.gestioneprenotazioni.repository.UtenteDAORepository;
import com.example.gestioneprenotazioni.repository.PostazioneDAORepository;
import com.example.gestioneprenotazioni.model.Utente;
import com.example.gestioneprenotazioni.model.Postazione;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Locale;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioneDAORepository prenotazioneRepository;

    @Autowired
    private UtenteDAORepository utenteRepository;

    @Autowired
    private PostazioneDAORepository postazioneRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("it-IT"));

        long count = prenotazioneRepository.count();
        Iterable<Utente> utenti = utenteRepository.findAll();
        Iterable<Postazione> postazioni = postazioneRepository.findAll();
        int addedCount = 0;

        for (Utente utente : utenti) {
            for (Postazione postazione : postazioni) {
                if (addedCount >= (10 - count)) {
                    break;
                }
                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setUtente(utente);
                prenotazione.setPostazione(postazione);
                prenotazione.setData(LocalDate.now().plusDays(faker.number().numberBetween(1, 30)));
                prenotazioneRepository.save(prenotazione);
                addedCount++;
            }
            if (addedCount >= (10 - count)) {
                break;
            }
        }
    }
}
