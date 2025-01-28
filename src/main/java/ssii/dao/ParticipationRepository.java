package ssii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ssii.entity.Participation;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Participation.ParticipationId> {
    List<Participation> findByPersonneMatricule(Integer matricule);
    List<Participation> findByProjetCode(Integer code);
    List<Participation> findByRole(String role);
}