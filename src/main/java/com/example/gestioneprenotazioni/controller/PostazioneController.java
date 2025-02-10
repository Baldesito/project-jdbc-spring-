package com.example.gestioneprenotazioni.controller;



import com.example.gestioneprenotazioni.model.Postazione;
import com.example.gestioneprenotazioni.service.PostazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postazioni")
public class PostazioneController {

    @Autowired
    private PostazioneService postazioneService;

    @GetMapping
    public List<Postazione> getAllPostazioni() {
        return postazioneService.getAllPostazioni();
    }

    @GetMapping("/{id}")
    public Postazione getPostazioneById(@PathVariable Long id) {
        return postazioneService.getPostazioneById(id);
    }

    @PostMapping
    public Postazione createPostazione(@RequestBody Postazione postazione) {
        return postazioneService.savePostazione(postazione);
    }

    @DeleteMapping("/{id}")
    public void deletePostazione(@PathVariable Long id) {
        postazioneService.deletePostazione(id);
    }
}
