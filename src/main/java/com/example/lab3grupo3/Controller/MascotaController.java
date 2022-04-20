package com.example.lab3grupo3.Controller;

import com.example.lab3grupo3.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Mascotas")
public class MascotaController {

    @Autowired
    MascotaRepository mascotaRepository;


    @GetMapping("/lista")
    public  String listarMascotas(Model model){
        model.addAttribute("listaMascotas",mascotaRepository.obtenerMascotasCantServicios());
        return "mascotas/lista";
    }

    @GetMapping("/edit")
    public String editarMascotas(){
        return "mascotas/editForm";
    }




}
