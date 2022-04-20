package com.example.lab3grupo3.Controller;


import com.example.lab3grupo3.Entity.Responsable;
import com.example.lab3grupo3.Entity.Servicio;
import com.example.lab3grupo3.Repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "Responsable")
public class ResponsableController {

    @Autowired
    ResponsableRepository responsableRepository;

   @GetMapping(value = "lista")
    public String listar(Model model){
        model.addAttribute("listaResponsables",responsableRepository.findAll());
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
    public String guardar(Responsable responsable, RedirectAttributes attr) {
        if(responsable.getNombre().equalsIgnoreCase("")){
            attr.addFlashAttribute("msg","No se ha ingresado el campo de nombre");
            return "redirect:/Responsable/crear";
        }else{
            responsableRepository.save(responsable);
            attr.addFlashAttribute("msg","Responsable agregado exitosamente");
            return "redirect:/Responsable/lista";
        }
    }

    @GetMapping(value = "eliminar")
    public String borrar(@RequestParam("id") String id) {
        return "redirect:/Responsables/lista";
    }
}
