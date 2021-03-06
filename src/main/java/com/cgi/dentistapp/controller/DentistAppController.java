package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/details").setViewName("details");
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO) {
        return "form";
    }

    @RequestMapping("/results")
    public String visitsList(Model model) {
        model.addAttribute("visits", dentistVisitService.listAll());
        model.addAttribute("dentistVisit", new DentistVisitDTO());
        return "results";
    }

    @RequestMapping(value="/results/name/{dentistName}", method= RequestMethod.GET)
    public String detail(@PathVariable(value="dentistName") String dentistName, Model model) {
        model.addAttribute("visits", dentistVisitService.findByName(dentistName));
        return "results";
    }

    @RequestMapping(value="/results/{id}", method= RequestMethod.GET)
    public String detail(@PathVariable(value="id") long id, Model model) {
        DentistVisitDTO dentistVisit = dentistVisitService.findById(id);
        model.addAttribute("dentistVisit", dentistVisit);
        return "details";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        dentistVisitService.addVisit(dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
        return "redirect:/results";
    }

    @RequestMapping(value="/results/delete/{id}", method= RequestMethod.GET)
    public String delete(@PathVariable(value="id") long id) {
        dentistVisitService.delete(id);
        return "redirect:/results";
    }

    @PostMapping("/results/update")
    public String putRegisterForm(@Valid DentistVisitDTO dentistVisitDTO) {

        dentistVisitService.updateVisit(dentistVisitDTO.getVisitId(), dentistVisitDTO.getDentistName(), dentistVisitDTO.getVisitTime());
        return "redirect:/results";
    }
}
