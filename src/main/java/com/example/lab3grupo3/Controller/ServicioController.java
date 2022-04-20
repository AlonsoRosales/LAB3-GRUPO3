package com.example.lab3grupo3.Controller;

import com.example.lab3grupo3.Entity.Cuenta;
import com.example.lab3grupo3.Entity.Servicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "Servicio")
public class ServicioController {


    @GetMapping(value = "lista")
    public String listar(Model model){
        return "servicios/list";
    }

    @GetMapping(value = "crear")
    public String crear() {
        return "servicios/new";
    }

    @GetMapping(value = "editar")
    public String editar(Model model, @RequestParam("id") String id) {
        return "servicios/edit";
    }

    @PostMapping(value = "guardar")
    public String guardar(Servicio servicio) {
        return "redirect:/Servicio/lista";
    }

    @GetMapping(value = "eliminar")
    public String borrar(@RequestParam("id") String id) {
        return "redirect:/Servicio/lista";
    }
}
