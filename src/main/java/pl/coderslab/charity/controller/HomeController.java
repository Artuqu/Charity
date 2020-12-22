package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {

     public final InstitutionRepository ir;

    @Autowired
    public HomeController(InstitutionRepository ir){
        this.ir=ir;
    }


    @RequestMapping("/")
    public String homeAction(Model m){

        List <Institution> institutions = ir.findAll();
        m.addAttribute("institutions", institutions);
        return "index";
    }


    @GetMapping("/ds")
    public String helloEach(Model m) {
        List <Institution> institutions = ir.findAll();
        m.addAttribute("institutions", institutions);
        return "fragments/fundations";
    }
}
