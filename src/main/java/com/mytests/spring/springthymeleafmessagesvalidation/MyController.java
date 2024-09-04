package com.mytests.spring.springthymeleafmessagesvalidation;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

    private final PersonValidator personValidator;

    public MyController(PersonValidator personValidator) {
        this.personValidator = personValidator;
    }
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) {
        binder.addValidators(personValidator);
    }
    @RequestMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("home_attr1", "test");
        return "home";
    }

    @GetMapping("/registration")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "person";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {

        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "person";
        }


        model.addAttribute("rez", "User " + person.getName() + " added successfully");
        return "redirect:/ok";

    }

    @RequestMapping("/ok")
    public String ok(ModelMap model) {
        model.addAttribute("ok_attr1", "have a nice day");
        return "ok";
    }
}
