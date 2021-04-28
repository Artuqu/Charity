package pl.coderslab.charity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.JpaCharityService;



@Controller
public class HomeController {

    private final JpaCharityService jcs;


    @Autowired
    public HomeController(JpaCharityService jcs) {
        this.jcs = jcs;

    }


    @GetMapping("/")
    public String homeAction(Model m) {
        m.addAttribute("institutions", jcs.findAllInstitution());
        m.addAttribute("bags", jcs.getBags());
        m.addAttribute("gifts", jcs.count());
        return "index";
    }

    @Secured("ROLE_USER")
    @GetMapping("/login")
    public String adminAction(Model m) {
        m.addAttribute("institutions", jcs.findAllInstitution());
        m.addAttribute("bags", jcs.getBags());
        m.addAttribute("gifts", jcs.count());
        return "admin/login";
    }

}
