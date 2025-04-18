package ma.emsi.controlespring.controller;

import ma.emsi.controlespring.projection.CampagneResume;
import ma.emsi.controlespring.services.CampagneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes")
public class CampagneController {

    private final CampagneService campagneService;

    public CampagneController(CampagneService campagneService) {
        this.campagneService = campagneService;
    }

    @GetMapping("/actives")
    public List<CampagneResume> getActives() {
        return campagneService.getCampagnesActives();
    }
}
