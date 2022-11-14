package com.yasir.VeterinaryProject.controller;

import com.yasir.VeterinaryProject.model.Owner;
import com.yasir.VeterinaryProject.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class OwnerController {


        private OwnerRepository ownerRepository;

        @Autowired
        public OwnerController(OwnerRepository ownerRepository){
                this.ownerRepository=ownerRepository;
        }

        @GetMapping({"/owners"})
        private ModelAndView getAllOwners(){
            ModelAndView mav=new ModelAndView("list-owner","owner",ownerRepository.findAll());
            return mav;
        }

        @GetMapping("/addOwner")
        public ModelAndView addOwner(){
            ModelAndView mav=new ModelAndView("add-owner","owners",new Owner());

            return mav;
        }

        @PostMapping("/saveOwner")
        public String saveOwner(@ModelAttribute Owner owner){
            ownerRepository.save(owner);

            return "redirect:/owners";
        }

        @GetMapping("/updateOwner")
        public ModelAndView updateOwner(@RequestParam Long ownerId){
            ModelAndView mav=new ModelAndView("add-owner","owners",ownerRepository.findById(ownerId).get());//frontend ile dolduralacak
            return mav;
        }

        @GetMapping("/deleteOwner")
        public String deleteOwner(@RequestParam Long ownerId){
            ownerRepository.deleteById(ownerId);

            return "redirect:/owners";
        }





    }
