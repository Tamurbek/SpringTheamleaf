package com.ssmtp.springtheamleaf.controller;

import com.ssmtp.springtheamleaf.dto.ApiResponse;
import com.ssmtp.springtheamleaf.dto.OwnerDto;
import com.ssmtp.springtheamleaf.model.Owner;
import com.ssmtp.springtheamleaf.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("api/v1/owner")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("owners",ownerRepository.findAll());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "newOwner";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute("owner") Owner owner,Model model) {
        ownerRepository.save(owner);
        model.addAttribute("owners",ownerRepository.findAll());
        return "index";
    }

    @GetMapping("/updateOwner/{id}")
    public String updateOwner(@PathVariable UUID id,Model model) {
        Owner owner = ownerRepository.getById(id);
        model.addAttribute("owner",owner);
        return "update";
    }


    @GetMapping("/getAllOwner")
    public String getAllOwner(Model model) {
        model.addAttribute("owners",ownerRepository.findAll());
        return "index";
    }

    @GetMapping("/deleteOwner/{id}")
    public String deleteOwner(@PathVariable UUID id,Model model) {
        ownerRepository.deleteById(id);
        model.addAttribute("owners",ownerRepository.findAll());
        return "index";
    }

}