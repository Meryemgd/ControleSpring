package ma.emsi.controlespring.repertoires;

import ma.emsi.controlespring.entites.Campagne;
import ma.emsi.controlespring.entites.Dons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationJPA extends JpaRepository<Dons, Long> {
}
