package ma.emsi.controlespring.repertoires;

import ma.emsi.controlespring.entites.Campagne;
import ma.emsi.controlespring.projection.CampagneResume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CampagneJPA extends JpaRepository<Campagne, Long> {

    List<CampagneResume> findByDateDebutBeforeAndDateFinAfter(LocalDate dateDebut, LocalDate dateFin);
}
