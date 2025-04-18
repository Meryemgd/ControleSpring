package ma.emsi.controlespring.services;

import ma.emsi.controlespring.entites.Campagne;
import ma.emsi.controlespring.projection.CampagneResume;
import ma.emsi.controlespring.repertoires.CampagneJPA;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CampagneService {

    private final CampagneJPA campagneRepository;

    public CampagneService(CampagneJPA campagneRepository) {
        this.campagneRepository = campagneRepository;
    }

    public List<CampagneResume> getCampagnesActives() {
        LocalDate now = LocalDate.now();
        return campagneRepository.findByDateDebutBeforeAndDateFinAfter(now, now);
    }
}

