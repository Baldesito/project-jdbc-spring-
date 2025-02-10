package com.example.gestioneprenotazioni.controller;


import com.example.gestioneprenotazioni.model.Prenotazione;
import com.example.gestioneprenotazioni.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioniController {

    @Autowired PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> getAllPrenotazioni(){
        return  prenotazioneService.getAllPrenotazioni();
    }

    @GetMapping("/{id}")
    public Optional<Prenotazione> getPrenotazioneById(@PathVariable Long id){
        return  prenotazioneService.getPrenotazioneById(id);
    }

    @PostMapping
    public Prenotazione createPrenotazione(@RequestBody Prenotazione prenotazione){
        return prenotazioneService.savePrenotazione(prenotazione);
    }

    @DeleteMapping("/{id}")
    public void deletePrenotazione(@PathVariable Long id){
        prenotazioneService.deletePrenotazione(id);
    }
}
