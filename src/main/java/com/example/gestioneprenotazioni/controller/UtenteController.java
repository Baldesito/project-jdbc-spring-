package com.example.gestioneprenotazioni.controller;

import com.example.gestioneprenotazioni.model.Utente;
import com.example.gestioneprenotazioni.repository.UtenteDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteDAORepository utenteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUtente(@PathVariable Long id) {
        return utenteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
