package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.calculator.Calculator;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

    public final InstitutionRepository ir;
    public final Calculator c;

    @Autowired
    public HomeController(InstitutionRepository ir, Calculator c)
    {
        this.ir = ir;
        this.c=c;
    }


    @GetMapping("/")
    public String homeAction(Model m) {
        List <Institution> institutions = ir.findAll ();
        m.addAttribute ( "institutions", institutions );
        List <Donation> getAllBags = c.getAllBags ();
        m.addAttribute ( "Bags", getAllBags );
        List <Donation> getAllGifts = c.getAllGifts();
        m.addAttribute ( "Gifts", getAllGifts );
        return "index";
    }



}
