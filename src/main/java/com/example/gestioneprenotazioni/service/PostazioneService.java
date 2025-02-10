package com.example.gestioneprenotazioni.service;

import com.example.gestioneprenotazioni.model.Postazione;
import com.example.gestioneprenotazioni.repository.PostazioneDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired private PostazioneDAORepository postazioneRepository;

    public List<Postazione> getAllPostazioni(){
        return postazioneRepository.findAll();
    }

    public Postazione getPostazioneById(Long id){
        return postazioneRepository.findById(id).orElse(null);
    }

    public  Postazione savePostazione(Postazione postazione){
        return postazioneRepository.save(postazione);
    }

    public void deletePostazione(Long id){
        postazioneRepository.deleteById(id);
    }
}
