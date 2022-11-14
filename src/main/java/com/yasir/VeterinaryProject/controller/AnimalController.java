package com.yasir.VeterinaryProject.controller;

import com.yasir.VeterinaryProject.model.Animal;
import com.yasir.VeterinaryProject.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnimalController {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository){
        this.animalRepository=animalRepository;
    }

    @GetMapping({"/animals"})
    public ModelAndView getAllAnimals(@RequestParam Long ownerId){

        ModelAndView mav=new ModelAndView("list-animal","animals",animalRepository.findAllByOwnerId(ownerId));

        return mav;
    }

    @GetMapping("/addAnimal")
    public ModelAndView addAnimal(@RequestParam Long ownerId){
        Animal animal = new Animal();
        animal.setOwnerId(ownerId);
        ModelAndView mav = new ModelAndView("add-animal","animal",animal);

        return mav;
    }

    @PostMapping("/saveAnimal")
    public String saveAnimal(@ModelAttribute Animal animal){

        animalRepository.save(animal);

        return "redirect:/animals?ownerId=" + animal.getOwnerId();
    }

    @GetMapping("/updateAnimal")
    public ModelAndView updateAnimal(@RequestParam Long animalId){
        ModelAndView mav=new ModelAndView("add-animal","animal",animalRepository.findById(animalId).get());

        return mav;
    }

    @GetMapping("/deleteAnimal")
    public String deleteAnimal(@RequestParam Long animalId){
            animalRepository.deleteById(animalId);

        return "redirect:/owners";
    }






}
