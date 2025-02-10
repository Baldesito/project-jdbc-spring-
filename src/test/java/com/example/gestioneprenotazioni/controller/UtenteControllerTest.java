package com.example.gestioneprenotazioni.controller;

import com.example.gestioneprenotazioni.SpringJdbcProjectApplication;
import com.example.gestioneprenotazioni.model.Utente;
import com.example.gestioneprenotazioni.repository.UtenteDAORepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = SpringJdbcProjectApplication.class)
public class UtenteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UtenteDAORepository utenteRepository;

    @Test
    public void testGetUtente() {
        // Creiamo e salviamo un utente per il test
        Utente utente = new Utente();
        utente.setUsername("mrossi");
        utente.setNomeCompleto("Mario Rossi");
        utente.setEmail("mario.rossi@example.com");
        Utente savedUser = utenteRepository.save(utente);

        // Eseguiamo la richiesta GET per ottenere l'utente
        ResponseEntity<Utente> response = restTemplate.getForEntity("/utenti/" + savedUser.getId(), Utente.class);

        // Verifichiamo che la risposta sia OK e non nulla
        assertEquals(200, response.getStatusCodeValue(), "La risposta dovrebbe essere OK");
        assertNotNull(response.getBody(), "Il corpo della risposta non dovrebbe essere nullo");
        assertEquals("mrossi", response.getBody().getUsername(), "Il username dell'utente dovrebbe essere 'mrossi'");
        assertEquals("Mario Rossi", response.getBody().getNomeCompleto(), "Il nome completo dell'utente dovrebbe essere 'Mario Rossi'");
    }
}

