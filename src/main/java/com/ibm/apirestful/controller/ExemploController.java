package com.ibm.apirestful.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exemplo")

public class ExemploController {

    @GetMapping(value = "/{nome}")
    public String exemplo (@PathVariable("nome") String nome){
        return "Olá " + nome;
    }
}
