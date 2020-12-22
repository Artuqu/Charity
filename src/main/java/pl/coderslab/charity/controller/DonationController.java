package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@RequestMapping("/donations")
@Controller
public class DonationController {

    private final DonationRepository dr;
    private final CategoryRepository cr;
    private final InstitutionRepository ir;

    @Autowired
    public DonationController(DonationRepository dr, CategoryRepository cr, InstitutionRepository ir) {
        this.dr = dr;
        this.cr = cr;
        this.ir = ir;
    }

    @GetMapping("")
    public String Form() {
        return "form";
    }

    @GetMapping("/all")
    public String getAllDonations(Model m){
        List<Donation> donations = dr.findAll ();
        m.addAttribute ("donations", donations);
        return "form";
    }

//    zapis do donation?
//    @Transactional
//    @PostMapping("/all")
//    public String addDonationPost(@ModelAttribute("donations") @Valid Donation donation, BindingResult result, Model m) {
//        if (result.hasErrors()) {
//            return "form";
//        }
//        this.dr.save(donation);
//        m.addAttribute("donations", donation);
//
//        return "form-confirmation";
//    }



}
