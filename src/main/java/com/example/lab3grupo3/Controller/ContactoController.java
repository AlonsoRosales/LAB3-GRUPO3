package com.example.lab3grupo3.Controller;

import com.example.lab3grupo3.Entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "Contacto")
public class ContactoController {



    @GetMapping(value = "lista")
    public String listar(Model model){
        return "contactos/list";
    }

    @GetMapping(value = "crear")
    public String crear() {
        return "contactos/new";
    }

    @GetMapping(value = "editar")
    public String editar(Model model, @RequestParam("id") String id) {
        return "contactos/edit";
    }

    @PostMapping(value = "guardar")
    public String guardar(Cuenta cuenta) {
        return "redirect:/Contactos/lista";
    }

    @GetMapping(value = "eliminar")
    public String borrar(@RequestParam("id") String id) {
        return "redirect:/Contactos/lista";
    }
}
