package com.example.lab3grupo3.Controller;

import com.example.lab3grupo3.Dto.DuenoDto;
import com.example.lab3grupo3.Entity.Cuenta;
import com.example.lab3grupo3.Entity.Mascota;
import com.example.lab3grupo3.Repository.CuentaRepository;
import com.example.lab3grupo3.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "Contacto")
public class ContactoController {

    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    MascotaRepository mascotaRepository;

    @GetMapping(value = "list")
    public String listar(Model model){
        List<DuenoDto> list = cuentaRepository.listarDuenos();
        model.addAttribute("lista",list);
        return "Contacto/lista";
    }

    @GetMapping(value = "new")
    public String crear() {
        return "Contacto/newForm";
    }

    @GetMapping(value = "edit")
    public String editar(Model model, @RequestParam("id") String id, RedirectAttributes attribute) {
        try {
            int idB = Integer.parseInt(id);
            if (idB>0){

                Optional<Cuenta> cuentas = cuentaRepository.findById(idB);
                if (cuentas.isPresent()){
                    model.addAttribute("dueno", cuentas.get());
                    List<Mascota> mascotas = mascotaRepository.findByCuenta(cuentas.get());
                    model.addAttribute("mascotas",mascotas);
                    return "Contacto/editForm";
                }
                return "redirect:/Contacto/list";
            }else{
                attribute.addFlashAttribute("msg","Formato invalido");
                return "redirect:/Contacto/list";
            }
        }catch (NumberFormatException e){
            attribute.addFlashAttribute("msg","Formato invalido");
            return "redirect:/Contacto/list";
        }

    }

    @PostMapping(value = "save")
    public String guardar(Cuenta cuenta, RedirectAttributes attr) {
        try {
            int telefono = Integer.parseInt(cuenta.getTelefono());
            if (cuenta.getId() == 0){
                attr.addFlashAttribute("msg", "Usuario creado exitosamente");
            }else{
                attr.addFlashAttribute("msg", "Usuario actualizado exitosamente");
            }
            cuentaRepository.save(cuenta);
            return "redirect:/Contacto/list";
        }catch (NumberFormatException e){
            attr.addFlashAttribute("msg","No ingreso datos validos");
            return "redirect:/Contacto/list";
        }

    }

    @GetMapping(value = "mascotas")
    public String listarMascota(Model model, @RequestParam("id") String id, RedirectAttributes attr) {
        try {
            int idB = Integer.parseInt(id);
            if (idB>0){
                Optional<Cuenta> cuentas = cuentaRepository.findById(idB);
                if (cuentas.isPresent()){
                    List<Mascota> mascotas = mascotaRepository.findByCuenta(cuentas.get());
                    model.addAttribute("mascotas",mascotas);
                    return "Contacto/listMascotas";
                }
                return "redirect:/Contacto/list";
            }else{
                attr.addFlashAttribute("msg","Formato invalido");
                return "redirect:/Contacto/list";
            }
        }catch (NumberFormatException e){
            attr.addFlashAttribute("msg","Formato invalido");
            return "redirect:/Contacto/list";
        }
    }

    @GetMapping(value = "delete")
    public String borrar(@RequestParam("id") String id, RedirectAttributes attributes) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(Integer.parseInt(id));
        if (cuenta.isPresent()){
            Cuenta cuenta1 = cuenta.get();
            List<Mascota> mascotas = mascotaRepository.findByCuenta(cuenta1);
            if (!mascotas.isEmpty()){
                attributes.addFlashAttribute("msg","No se puede eliminar la cuenta ya que cuenta con mascotas a su nombre");
                return "redirect:/Contacto/list";
            }else {
                cuentaRepository.deleteById(cuenta1.getId());
                attributes.addFlashAttribute("msg","Cuenta elminada exitosamente");
                return "redirect:/Contacto/list";
            }
        }
        return "redirect:/Contacto/list";
    }
}
