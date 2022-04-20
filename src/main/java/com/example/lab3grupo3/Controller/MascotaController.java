package com.example.lab3grupo3.Controller;

import com.example.lab3grupo3.Entity.Mascota;
import com.example.lab3grupo3.Entity.RazaEspecie;
import com.example.lab3grupo3.Repository.CuentaRepository;
import com.example.lab3grupo3.Repository.MascotaRepository;
import com.example.lab3grupo3.Repository.RazaEspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.CascadeType;
import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("/Mascotas")
public class MascotaController {

    @Autowired
    MascotaRepository mascotaRepository;
    @Autowired
    RazaEspecieRepository razaEspecieRepository;
    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("/lista")
    public String listarMascotas(Model model) {
        model.addAttribute("mascotaServicio", mascotaRepository.obtenerMascotasCantServicios());
        return "mascotas/lista";
    }

    @GetMapping("/edit")
    public String editarMascotas(Model model, @RequestParam("id") Integer id) {
        if (id == null) {
            return "redirect:/Mascotas/lista";
        }
        Optional<Mascota> optionalMascota = mascotaRepository.findById(id);
        if (optionalMascota.isEmpty()) {
            return "redirect:/Mascotas/lista";
        }
        model.addAttribute("mascota", optionalMascota.get());
        model.addAttribute("razas", razaEspecieRepository.findAll());
        model.addAttribute("cuentas", cuentaRepository.findAll());
        return "mascotas/editForm";
    }

    @GetMapping("/delete")
    public String deleteMascotas(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        if (id != null) {
            Optional<Mascota> optionalMascota = mascotaRepository.findById(id);
            if (optionalMascota.isPresent()) {
                mascotaRepository.deleteById(id);
                redirectAttributes.addFlashAttribute("msg", "Mascota borrada exitosamente");
            }
        }
        return "redirect:/Mascotas/lista";
    }
    @GetMapping("/new")
    public String newMascotas(Model model) {
        model.addAttribute("razas", razaEspecieRepository.findAll());
        model.addAttribute("cuentas", cuentaRepository.findAll());
        return "/mascotas/newForm";
    }

    @PostMapping("/save")
    public String saveMascotas(Mascota mascota, RedirectAttributes redirectAttributes){
        if(mascota.getId()==null){
            redirectAttributes.addFlashAttribute("msg","Se ha creado la mascota correctamente");
        } else {
            redirectAttributes.addFlashAttribute("msg","Se ha editado la mascota correctamente");
        }
        mascotaRepository.save(mascota);

        return "redirect:/Mascotas/lista";
    }
}
