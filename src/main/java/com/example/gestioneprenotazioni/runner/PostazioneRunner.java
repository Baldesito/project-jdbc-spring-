package com.example.gestioneprenotazioni.runner;

import com.example.gestioneprenotazioni.model.Postazione;
import com.example.gestioneprenotazioni.repository.PostazioneDAORepository;
import com.example.gestioneprenotazioni.repository.EdificioDAORepository;
import com.example.gestioneprenotazioni.Enumeration.TipoPostazione;
import com.example.gestioneprenotazioni.model.Edificio;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PostazioneRunner implements CommandLineRunner {

    @Autowired
    private PostazioneDAORepository postazioneRepository;

    @Autowired
    private EdificioDAORepository edificioRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("it-IT"));

        long count = postazioneRepository.count();
        edificioRepository.findAll().forEach(edificio -> {
            for (int i = 0; i < (10 - count); i++) {
                Postazione postazione = new Postazione(
                    faker.code().isbn10(),
                    faker.lorem().sentence(),
                    TipoPostazione.values()[faker.number().numberBetween(0, 2)],
                    faker.number().numberBetween(1, 10),
                    edificio
                );
                postazioneRepository.save(postazione);
            }
        });
    }
}

