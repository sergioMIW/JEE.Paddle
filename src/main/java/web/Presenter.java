package web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import business.controllers.CourtController;
import business.wrapper.CourtState;
import data.entities.Court;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class Presenter {

    private static final List<String> THEMES = Arrays.asList("jsp", "bootstrap");

    @Autowired
    private CourtController courtController;

    private String theme = THEMES.get(0);

    public Presenter() {
    }

    // Se ejecuta siempre y antes. Añade un atributo al Model
    @ModelAttribute("now")
    public String now() {
        return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
    }

    @RequestMapping("/home")
    public String style(Model model) {
        model.addAttribute("themes", THEMES);
        model.addAttribute("selectOptions", activeThemeMap());
        // La vista resultante no lleva extensión (.jsp) configurado en WebConfig.java
        return theme + "/home";
    }

    @RequestMapping(value = "/create-court", method = RequestMethod.GET)
    public String createCourt(Model model) {
        int id = courtController.showCourts().size() + 1;
        model.addAttribute("court", new CourtState(new Court(id)));
        model.addAttribute("selectActiveOptions", activeCourtMap());
        return theme + "/createCourt";
    }

    @RequestMapping(value = "/create-court", method = RequestMethod.POST)
    public String createCourtSubmit(@ModelAttribute(value = "court") CourtState court, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            if (courtController.createCourt(court.getCourtId())) {
                // courtController.changeCourtActivation(court.getCourtId(), court.isActive());
                model.addAttribute("court", court);
                return theme + "/registrationSuccess";
            } else {
                bindingResult.rejectValue("id", "error.courtId", "Court ya existente");
            }
        }

        return theme + "/createCourt";
    }

    @RequestMapping("/court-list")
    public ModelAndView listCourts() {
        ModelAndView modelAndView = new ModelAndView(theme + "/courtList");
        modelAndView.addObject("courtList", courtController.showCourts());
        return modelAndView;
    }

    @RequestMapping(value = {"/delete-court/{id}"})
    public String deleteCourt(@PathVariable int id, Model model) {
        if (courtController.delete(id)) {
            model.addAttribute("courtDelete", "Se ha borrado con exito");
        } else {
            model.addAttribute("courtDelete", "No ha sido posible eliminarlo");
        }

        model.addAttribute("courtList", courtController.showCourts());
        return theme + "/courtList";
    }

    public Map<Boolean, String> activeCourtMap() {
        Map<Boolean, String> activeCourtMap = new HashMap<>();
        activeCourtMap.put(true, "Activo");
        activeCourtMap.put(false, "Inactivo");
        return activeCourtMap;
    }

    public Map<String, String> activeThemeMap() {
        Map<String, String> activeCourtMap = new HashMap<>();
        activeCourtMap.put("jsp", "jsp");
        activeCourtMap.put("bootstrap", "bootstrap");
        return activeCourtMap;
    }

    public void setTheme(int themeID) {
        this.theme = THEMES.get(themeID);
    }

    @RequestMapping(value = {"/select-theme/{id}"})
    public String setThemeView(@PathVariable int id) {
        setTheme(id);
        return theme + "/home";
    }

}
