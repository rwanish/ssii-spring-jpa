package ssii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssii.dao.ParticipationRepository;
import ssii.dao.PersonneRepository;
import ssii.dao.ProjetRepository;
import ssii.entity.Participation;
import ssii.entity.Personne;
import ssii.entity.Projet;

import java.util.List;

@Service
public class ParticipationService {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private ParticipationRepository participationRepository;

    public void enregistrerParticipation(Integer matricule, Integer code, String role, Float pourcentage) {
        Personne personne = personneRepository.findById(matricule).orElseThrow(() -> new RuntimeException("Personne non trouvée"));
        Projet projet = projetRepository.findById(code).orElseThrow(() -> new RuntimeException("Projet non trouvé"));

        List<Participation> participations = personne.getParticipations();
        double totalPourcentage = participations.stream().mapToDouble(Participation::getPourcentage).sum();

        if (participations.stream().anyMatch(p -> p.getProjet().equals(projet))) {
            throw new RuntimeException("La personne participe déjà à ce projet");
        }

        if (totalPourcentage + pourcentage > 100) {
            throw new RuntimeException("La personne ne peut pas être occupée à plus de 100%");
        }

        if (participations.size() >= 3) {
            throw new RuntimeException("La personne ne peut pas participer à plus de trois projets en même temps");
        }

        Participation participation = new Participation(matricule, code, personne, projet, role, pourcentage);
        participationRepository.save(participation);
        personne.getParticipations().add(participation);
        personneRepository.save(personne);
    }
}