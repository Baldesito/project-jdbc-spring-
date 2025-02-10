package com.example.gestioneprenotazioni.repository;

import com.example.gestioneprenotazioni.SpringJdbcProjectApplication;
import com.example.gestioneprenotazioni.model.Utente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = SpringJdbcProjectApplication.class)
public class UtenteDAORepositoryTest {

    @Autowired
    private UtenteDAORepository utenteRepository;

    @Test
    public void testSaveAndFindById() {
        // Creiamo e salviamo un utente per il test
        Utente utente = new Utente();
        utente.setUsername("testuser");
        utente.setNomeCompleto("Test User");
        utente.setEmail("test.user@example.com");
        Utente savedUser = utenteRepository.save(utente);

        // Recuperiamo l'utente dal repository e verifichiamo che non sia nullo
        Utente foundUser = utenteRepository.findById(savedUser.getId()).orElse(null);
        assertNotNull(foundUser, "L'utente con ID " + savedUser.getId() + " dovrebbe esistere");
    }
}
