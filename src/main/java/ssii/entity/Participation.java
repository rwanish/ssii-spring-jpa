package ssii.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Participation {

    @EmbeddedId
    private ParticipationId id;

    @ManyToOne
    @MapsId("matricule")
    @JoinColumn(name = "matricule", insertable = false, updatable = false)
    private Personne personne;

    @ManyToOne
    @MapsId("code")
    @JoinColumn(name = "code", insertable = false, updatable = false)
    private Projet projet;

    @NonNull
    private String role;

    @NonNull
    private Float pourcentage;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class ParticipationId implements java.io.Serializable {
        private Integer matricule;
        private Integer code;
    }

    public Participation(Integer matricule, Integer code, Personne personne, Projet projet, String role, Float pourcentage) {
        this.id = new ParticipationId(matricule, code);
        this.personne = personne;
        this.projet = projet;
        this.role = role;
        this.pourcentage = pourcentage;
    }
}