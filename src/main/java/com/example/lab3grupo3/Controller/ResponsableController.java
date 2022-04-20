package com.example.lab3grupo3.Controller;


import com.example.lab3grupo3.Entity.Responsable;
import com.example.lab3grupo3.Entity.Servicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping(value = "Responsable")
public class ResponsableController {

    @GetMapping(value = "lista")
    public String listar(Model model){
        model.addAttribute("listaResponsables","");
        return "responsables/list";
    }

    @GetMapping(value = "crear")
    public String crear() {
        return "responsables/new";
    }

    @GetMapping(value = "editar")
    public String editar(Model model, @RequestParam("id") String id) {
        return "responsables/list";
    }

    @PostMapping(value = "guardar")
    public String guardar(Responsable responsable) {
        return "redirect:/Responsables/lista";
    }

    @GetMapping(value = "eliminar")
    public String borrar(@RequestParam("id") String id) {
        return "redirect:/Responsables/lista";
    }
}
