package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.CityService;
import com.codegym.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Page<Country> countries(Pageable pageable) {
        return countryService.findAll(pageable);
    }

    @GetMapping("/create-city")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView createCustomer(@Valid @ModelAttribute("city") City city, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("message","Fail Create City");
            return modelAndView;
        } else {

            cityService.save(city);
            modelAndView.addObject("city", city);
            modelAndView.addObject("message","Create City successfully");
            return modelAndView;
        }
    }

    @GetMapping("/cities")
    public ModelAndView listCustomer(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/city/list");
        Page<City> cities = cityService.findAll(pageable);
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping("/edit-city")
    public ModelAndView editCustomer(@Valid @ModelAttribute("city") City city, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("message","Fail Edit City");
            return modelAndView;
        } else {

            cityService.save(city);
            modelAndView.addObject("city", city);
            modelAndView.addObject("message","Edit City successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/city/delete");
        City city = cityService.findById(id);
        modelAndView.addObject("city",city);
        return modelAndView;
    }

    @PostMapping("/delete-city")
    public ModelAndView deleteCustomer(@ModelAttribute("city") City city, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/city/list");
        cityService.remove(city.getId());
        Page<City> cities = cityService.findAll(pageable);
        modelAndView.addObject("cities",cities);

        return modelAndView;
    }

    @GetMapping("/view-city/{id}")
    public ModelAndView viewCustomer(@PathVariable("id") Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/view");
        modelAndView.addObject("city",city);
        return modelAndView;
    }

}
