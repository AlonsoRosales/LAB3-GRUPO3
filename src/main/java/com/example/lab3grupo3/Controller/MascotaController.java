package com.example.lab3grupo3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Mascotas")
public class MascotaController {

    @GetMapping("")
    public String home(){
        return "index";
    }

    @GetMapping("/list")
    public  String listarMascotas(){
        return "/mascotas/lista";
    }




}
