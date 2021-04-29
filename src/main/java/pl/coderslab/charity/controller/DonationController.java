package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.JpaCharityService;

import javax.validation.Valid;

@Controller
public class DonationController {

    private final JpaCharityService jcs;

    @Autowired
    public DonationController(JpaCharityService jcs) {
        this.jcs = jcs;
    }

    @GetMapping("/donations")
    public String saveDonationGet(Model m) {
        m.addAttribute("donation", new Donation());
        return getString(m);
    }

    @PostMapping("/donations")
    public String saveDonationPost(@ModelAttribute("donation") @Valid Donation donation, BindingResult result, Model m) {
        if (result.hasErrors()) {
            return getString(m);
        }

        try {
            this.jcs.save(donation);
            m.addAttribute("donation", donation);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            m.addAttribute("message", "Operation failed");
            return getString(m);
        }
        this.jcs.save(donation);
        return "confirmation";
    }

    private String getString(Model m) {
        m.addAttribute("categories", jcs.findAllCategory());
        m.addAttribute("institutions", jcs.findAllInstitution());
        m.addAttribute("donations", jcs.findAllDonation());
        return "form";
    }
}
