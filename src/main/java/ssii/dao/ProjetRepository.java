package ssii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ssii.entity.Projet;

import java.time.LocalDate;
import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
    List<Projet> findByNom(String nom);
    List<Projet> findByDebutAfter(LocalDate debut);
    List<Projet> findByFinBefore(LocalDate fin);
}