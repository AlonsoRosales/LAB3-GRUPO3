package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.DTO.MascotasCantServicios;
import com.example.lab3grupo3.DTO.MascotasServicios;
import com.example.lab3grupo3.Entity.Cuenta;
import com.example.lab3grupo3.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    List<Mascota> findByCuenta(Cuenta cuenta);

    @Query(nativeQuery = true,value = "SELECT idmascota as id,nombre as nombre,anho as anho,sexo as sexo,descripcion as descripcion,raza_otros as raza,count(mascota_idmascota) as cantservicios FROM mascota INNER JOIN raza_especie ON ( raza_especie.idraza = mascota.raza_especie_idraza) LEFT JOIN servicio ON (servicio.mascota_idmascota = mascota.idmascota) GROUP BY nombre;")
    List<MascotasCantServicios> obtenerMascotasCantServicios();

    @Query(nativeQuery = true,value = "SELECT mascota.nombre as nombreMascota,anho as anho,hora_inicio as horaInicio,duracion as duracion,entrega as entrega,responsable.nombre as responsable,opcion.descripcion as servicio FROM servicio INNER JOIN responsable ON ( responsable.idresponsable = servicio.responsable_idresponsable) LEFT JOIN mascota ON ( mascota.idmascota = servicio.mascota_idmascota) INNER JOIN opcion_servicio ON ( opcion_servicio.servicio_idservicio = servicio.idservicio) INNER JOIN opcion ON ( opcion.idopcion = opcion_servicio.opcion_idopcion) WHERE idmascota = ?1;")
    List<MascotasServicios> obtenerServiciosMascota(int id);
}