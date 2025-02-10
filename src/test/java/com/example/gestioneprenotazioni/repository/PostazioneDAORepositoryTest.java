package com.example.gestioneprenotazioni.repository;

import com.example.gestioneprenotazioni.model.Postazione;
import com.example.gestioneprenotazioni.Enumeration.TipoPostazione;
import com.example.gestioneprenotazioni.model.Edificio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PostazioneDAORepositoryTest {

    @Autowired
    private PostazioneDAORepository postazioneRepository;

    @Autowired
    private EdificioDAORepository edificioRepository;

    @Test
    public void testFindByTipoAndCitta() {
        // Creiamo e salviamo un edificio per il test
        Edificio edificio = new Edificio();
        edificio.setNome("Edificio Test");
        edificio.setIndirizzo("Via Test, 123");
        edificio.setCitta("TestCity");
        Edificio savedEdificio = edificioRepository.save(edificio);

        // Creiamo e salviamo una postazione per il test
        Postazione postazione = new Postazione();
        postazione.setCodice("P12345");
        postazione.setDescrizione("Postazione di test");
        postazione.setTipo(TipoPostazione.PRIVATO);
        postazione.setNumeroMassimoOccupanti(4);
        postazione.setEdificio(savedEdificio);
        postazioneRepository.save(postazione);

        // Ricerca delle postazioni per tipo e città
        List<Postazione> postazioni = postazioneRepository.findByTipoAndEdificio_Citta(TipoPostazione.PRIVATO, "TestCity");

        // Verifica che la ricerca sia corretta
        assertEquals(1, postazioni.size());
    }
}
