package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/donations")
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




}
