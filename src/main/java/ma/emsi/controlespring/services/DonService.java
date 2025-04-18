package ma.emsi.controlespring.services;

import ma.emsi.controlespring.dtos.DonDTO;
import ma.emsi.controlespring.entites.Campagne;
import ma.emsi.controlespring.entites.Dons;
import ma.emsi.controlespring.repertoires.CampagneJPA;
import ma.emsi.controlespring.repertoires.DonationJPA;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DonService {

    private final DonationJPA donRepository;
    private final CampagneJPA campagneRepository;

    public DonService(DonationJPA donRepository, CampagneJPA campagneRepository) {
        this.donRepository = donRepository;
        this.campagneRepository = campagneRepository;
    }

    public DonDTO saveDon(Long campagneId, DonDTO dto) {
        Campagne campagne = campagneRepository.findById(campagneId)
                .orElseThrow(() -> new RuntimeException("Campagne non trouvée"));

        Dons don = new Dons();
        don.setCampagne(campagne);
        don.setNomDonateur(dto.getNomDonateur());
        don.setMontant(dto.getMontant());
        don.setDate(LocalDate.now());

        Dons saved = donRepository.save(don);

        dto.setId(saved.getId());
        dto.setNomCampagne(campagne.getNom());
        dto.setDate(saved.getDate());

        return dto;
    }
}
