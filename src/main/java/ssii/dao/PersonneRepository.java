package ssii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ssii.entity.Personne;

import java.util.List;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {
    List<Personne> findByNom(String nom);
    List<Personne> findByPrenom(String prenom);
}