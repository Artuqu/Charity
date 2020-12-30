package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.JpaCharityService;

import java.util.List;


@Controller
public class HomeController {

    private final JpaCharityService jcs;
    private final DonationRepository dr;


    @Autowired
    public HomeController(JpaCharityService jcs, DonationRepository dr)
    {
        this.jcs = jcs;
        this.dr=dr;

    }


    @GetMapping("/")
    public String homeAction(Model m) {
        List <Institution> institutions = jcs.findAllInstitution ();
        m.addAttribute ( "institutions", institutions );
        m.addAttribute ( "bags", dr.getSumOfBags() );
        m.addAttribute ( "gifts", jcs.count() );
        return "index";
    }

}
