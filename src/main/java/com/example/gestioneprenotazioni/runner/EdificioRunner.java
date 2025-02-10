package com.example.gestioneprenotazioni.runner;

import com.example.gestioneprenotazioni.model.Edificio;
import com.example.gestioneprenotazioni.repository.EdificioDAORepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class EdificioRunner implements CommandLineRunner {

    @Autowired
    private EdificioDAORepository edificioRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("it-IT"));

        long count = edificioRepository.count();
        for (int i = 0; i < (10 - count); i++) {
            Edificio edificio = new Edificio();
            edificio.setNome(faker.company().name());
            edificio.setIndirizzo(faker.address().streetAddress());
            edificio.setCitta(faker.address().city());
            edificioRepository.save(edificio);
        }
    }
}
