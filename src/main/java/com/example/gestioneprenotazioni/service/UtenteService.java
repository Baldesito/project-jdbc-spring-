package com.example.gestioneprenotazioni.service;


import com.example.gestioneprenotazioni.model.Utente;
import com.example.gestioneprenotazioni.repository.UtenteDAORepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired UtenteDAORepository utenteRepository;

    @Transactional
    public void retainOnlyFirstTenUsers() {
        utenteRepository.deleteUsersNotInFirstTen();
    }

    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Utente getUtenteById(Long id) {
        return utenteRepository.findById(id).orElse(null);
    }

    public  Utente saveUtente(Utente utente){
        return utenteRepository.save(utente);
    }

    public void deleteUtente(Long id){
        utenteRepository.deleteById(id);
    }
}
