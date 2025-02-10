package com.example.gestioneprenotazioni.controller;



import com.example.gestioneprenotazioni.model.Edificio;
import com.example.gestioneprenotazioni.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edifici")
public class EdificioController {

    @Autowired
    private EdificioService edificioService;

    @GetMapping
    public List<Edificio> getAllEdifici() {
        return edificioService.getAllEdifici();
    }

    @GetMapping("/{id}")
    public Edificio getEdificioById(@PathVariable Long id) {
        return edificioService.getEdificioById(id);
    }

    @PostMapping
    public Edificio createEdificio(@RequestBody Edificio edificio) {
        return edificioService.saveEdificio(edificio);
    }

    @DeleteMapping("/{id}")
    public void deleteEdificio(@PathVariable Long id) {
        edificioService.deleteEdificio(id);
    }
}
