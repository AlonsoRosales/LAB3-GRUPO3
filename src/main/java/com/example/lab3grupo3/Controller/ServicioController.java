package com.example.lab3grupo3.Controller;

import com.example.lab3grupo3.Entity.*;
import com.example.lab3grupo3.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Servicio")
public class ServicioController {

    @Autowired
    OpcionServicioRepository opcionServicioRepository;

    @Autowired
    ResponsableRepository responsableRepository;

    @Autowired
    OpcionRepository opcionRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @GetMapping("/lista")
    public String listar(Model model){
        List<Opcion> list = opcionRepository.findAll();
        model.addAttribute("listaServicios",list);
        return "servicio/lista";
    }

    @GetMapping("/new")
    public String nuevo(){
        return "servicio/newForm";
    }

    @GetMapping("/editar")
    public String editar(Model model, @RequestParam("id") int id) {

        model.addAttribute("service",opcionRepository.obtenerOpcionById(id)); //No era necesario crear el query xd
        return "servicio/edit";
    }

    @PostMapping("/save")
    public String guardarProducto(Opcion opcion, RedirectAttributes redirectAttributes) {
        if(opcion.getId() == null){
            redirectAttributes.addFlashAttribute("msg1", "Servicio creado exitosamente");
        }
        else{
            redirectAttributes.addFlashAttribute("msg2","Servicio editado exitosamente");
        }
        opcionRepository.save(opcion);
        //opcionServicioRepository.save(opcionServicio);
        return "redirect:/Servicio/lista";
    }

    @GetMapping("/delete")
    public String borrarTransportista(@RequestParam("id") int id,RedirectAttributes redirectAttributes) {
        opcionRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg3","Servicio borrado exitosamente");
        return "redirect:/Servicio/lista";
    }

    @GetMapping("/detalles")
    public String detalles(RedirectAttributes attr,Model model,@RequestParam("id") String mascotaId){
        try{
            Optional<Mascota> opt = mascotaRepository.findById(Integer.parseInt(mascotaId));
            if(opt.isPresent()){
                model.addAttribute("mascota",opt.get());
                model.addAttribute("mascotaServicios",mascotaRepository.obtenerServiciosMascota(Integer.parseInt(mascotaId)));
                return "servicio/indice";
            }else{
                attr.addFlashAttribute("msg","No se encontro una mascota con el ID dado");
                return "mascota/lista";
            }
        }catch (Exception e){
            attr.addAttribute("msg","Ingreso un id invalido");
            return "mascota/lista";
        }

    }

    @GetMapping("/serviciomascota")
    public String nuevoServicio(RedirectAttributes attr,Model model,@RequestParam("id") String mascotaId){
        try{
            Optional<Mascota> opt = mascotaRepository.findById(Integer.parseInt(mascotaId));
            if(opt.isPresent()){
                model.addAttribute("mascota",opt.get());
                model.addAttribute("listaCuenta", cuentaRepository.findAll());
                model.addAttribute("listaResponsable",responsableRepository.responsablespormascota(Integer.parseInt(mascotaId)));
                return "servicio/detalles";
            }else{
                attr.addFlashAttribute("msg","No se encontro una mascota con el ID dado");
                return "mascota/lista";
            }
        }catch (Exception e){
            attr.addAttribute("msg","Ingreso un id invalido");
            return "mascota/lista";
        }
    }
    @PostMapping("/registrarservicio")
    public String registrarServicio(RedirectAttributes attr,Servicio servicio){
        if(true){
            servicioRepository.save(servicio);
            attr.addFlashAttribute("msg","Se creo el servicio exitosamente");
            return "redirect:/Mascotas/lista";
        }else{
            attr.addFlashAttribute("msg","Se envio un campo nulo");
            return "redirect:/Mascotas/lista";
        }
    }

    @GetMapping("/detallesMascotas")
    public String detallesServicio(@RequestParam("id") Integer id, Model model){
        if(id!=null && mascotaRepository.findById(id).isPresent()){
            model.addAttribute("servicios", mascotaRepository.obtenerServiciosMascota(id));
            return "mascotas/detalles";
        }
        return "redirect:/servicio/lista";
    }
}
