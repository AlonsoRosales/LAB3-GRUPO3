package com.example.lab3grupo3.Controller;

import com.example.lab3grupo3.Entity.Cuenta;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Mascotas")
public class MascotaController {

    @GetMapping(value = "lista")
    public String listar(Model model){
        return "mascota/list";
    }

    @GetMapping(value = "crear")
    public String crear() {
        return "mascota/new";
    }

    @GetMapping(value = "editar")
    public String editar(Model model, @RequestParam("id") String id) {
        return "mascota/edit";
    }

    @PostMapping(value = "guardar")
    public String guardar(Cuenta cuenta) {
        return "redirect:/Mascota/lista";
    }

    @GetMapping(value = "eliminar")
    public String borrar(@RequestParam("id") String id) {
        return "redirect:/Mascota/lista";
    }

}
