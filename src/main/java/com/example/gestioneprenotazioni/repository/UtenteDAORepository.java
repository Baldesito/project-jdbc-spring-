package com.example.gestioneprenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.gestioneprenotazioni.model.Utente;

@Repository
public interface UtenteDAORepository extends JpaRepository<Utente, Long> {

    @Modifying
    @Query("DELETE FROM Utente u WHERE u.id NOT IN (SELECT u2.id FROM Utente u2 ORDER BY u2.id ASC LIMIT 10)")
    void deleteUsersNotInFirstTen();
}
