package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.JpaCharityService;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/donations")
@Controller
public class DonationController {


    private final JpaCharityService jcs;


    @Autowired
    public DonationController(JpaCharityService jcs) {
        this.jcs = jcs;

    }


    @GetMapping("")
    public String saveDonationGet(Model m){
        m.addAttribute("donation", new Donation());
        return getString(m);
    }


    @PostMapping("")
    public String saveDonationPost(@ModelAttribute("donation") @Valid Donation donation,
                                   BindingResult result,
                                   Model m) {
        if (result.hasErrors()) {
            return getString(m);

        }
        this.jcs.save(donation);
        m.addAttribute("donation", donation);

        return "redirect:donations";
    }


    private String getString(Model m) {
        Donation donation = new Donation();
        m.addAttribute("donation", donation);

        List<Category> categories = jcs.findAllCategory();
        m.addAttribute("categories", categories);

        List<Institution> institutions = jcs.findAllInstitution();
        m.addAttribute("institutions", institutions);

        List<Donation> donations = jcs.findAllDonation();
        m.addAttribute("donations", donations);

        return "form";
    }



}
