package com.example.gestioneprenotazioni.service;

import com.example.gestioneprenotazioni.model.Edificio;
import com.example.gestioneprenotazioni.repository.EdificioDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {

    @Autowired private EdificioDAORepository edificioRepository;

    public List<Edificio> getAllEdifici(){
        return  edificioRepository.findAll();
    }

    public  Edificio getEdificioById(Long id){
        return edificioRepository.findById(id).orElse(null);
    }

    public Edificio saveEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public void deleteEdificio(Long id) {
        edificioRepository.deleteById(id);
    }
}
