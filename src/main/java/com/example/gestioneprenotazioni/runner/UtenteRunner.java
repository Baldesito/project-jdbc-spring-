package com.example.gestioneprenotazioni.runner;

import com.example.gestioneprenotazioni.model.Utente;
import com.example.gestioneprenotazioni.repository.UtenteDAORepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UtenteRunner implements CommandLineRunner {

    @Autowired
    private UtenteDAORepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("it-IT"));

        long count = utenteRepository.count();
        for (int i = 0; i < (8 - count); i++) {
            Utente utente = new Utente();
            utente.setUsername(faker.name().username());
            utente.setNomeCompleto(faker.name().fullName());
            utente.setEmail(faker.internet().emailAddress());
            utenteRepository.save(utente);
        }
    }
}

