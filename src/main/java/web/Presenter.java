package web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import data.entities.Court;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class Presenter {

    private static final List<String> THEMES = Arrays.asList("jsp", "bootstrap", "thymeleaf");

    @Autowired
    private ServletContext servletContext;

   
    private String theme = THEMES.get(0);

    public Presenter() {
    }

    // Se ejecuta siempre y antes. Añade un atributo al Model
    @ModelAttribute("now")
    public String now() {
        return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
    }

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("themes", THEMES);
        //La vista resultante no lleva extensión (.jsp) configurado en WebConfig.java
        return theme + "/home";
    }

    @RequestMapping(value = "/create-court", method = RequestMethod.GET)
    public String createCourt(Model model) {
        model.addAttribute("court", new Court(CourtService.generateId()));
        model.addAttribute("active", CourtService.activeCourtMap());
        return theme + "/createUser";
    }
    
    @RequestMapping(value = "/create-court", method = RequestMethod.POST)
    public String createCourtSubmit(@Valid Court court, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (CourtService.save(court)) {
                model.addAttribute("id", court.getId());
                return theme + "/registrationSuccess";
            } else {
                bindingResult.rejectValue("id", "error.court", "Court ya existente");
            }
        }
        model.addAttribute("active", CourtService.activeCourtMap());
        return theme + "/createCourt";
    }



    

}
