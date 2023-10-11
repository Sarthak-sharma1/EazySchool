package com.eazybytes.eazyschool.controller;

import com.eazybytes.eazyschool.model.Address;
import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.model.Profile;
import com.eazybytes.eazyschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller("profileControllerBean")
public class ProfileController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/displayProfile")
    public ModelAndView displayMessages(Model model, HttpSession session){
        Person person = (Person) session.getAttribute("loggedInPerson");
        Profile profile = new Profile();
        profile.setName(person.getName());
        profile.setMobileNumber(person.getMobileNumber());
        profile.setEmail(person.getEmail());
        Optional.ofNullable(person.getAddress())
                .filter(address -> address.getAddressId() > 0 )
                .ifPresent(address -> {
                    profile.setAddress1(address.getAddress1());
                    profile.setAddress2(address.getAddress2());
                    profile.setCity(address.getCity());
                    profile.setState(address.getState());
                    profile.setZipCode(address.getZip_code());
                });
        ModelAndView modelAndView = new ModelAndView("profile.html");
        modelAndView.addObject("profile",profile);

        return modelAndView;
    }

    @PostMapping(value = "/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors errors,
                                HttpSession session){
        if (errors.hasErrors())
            return "profile.html";

        Person person = (Person) session.getAttribute("loggedInPerson");
        person.setName(profile.getName());
        person.setMobileNumber(profile.getMobileNumber());
        person.setEmail(profile.getEmail());
        if (person.getAddress() == null || !(person.getAddress().getAddressId()>0))
            person.setAddress(new Address());

        person.getAddress().setAddress1(profile.getAddress1());
        person.getAddress().setAddress2(profile.getAddress2());
        person.getAddress().setCity(profile.getCity());
        person.getAddress().setState(profile.getState());
        person.getAddress().setZip_code(profile.getZipCode());

        Person savedPerson = personRepository.save(person);
        session.setAttribute("loggedInPerson",savedPerson);


        return "redirect:/displayProfile";
    }
}
