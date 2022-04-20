package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.DTO.MascotasCantServicios;
import com.example.lab3grupo3.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    @Query(nativeQuery = true,value = "SELECT idmascota as id,nombre as nombre,anho as anho,sexo as sexo,descripcion as descripcion,raza_otros as raza,count(mascota_idmascota) as cantservicios FROM mascota INNER JOIN raza_especie ON ( raza_especie.idraza = mascota.raza_especie_idraza) LEFT JOIN servicio ON (servicio.mascota_idmascota = mascota.idmascota) GROUP BY nombre;")
    List<MascotasCantServicios> obtenerMascotasCantServicios();
}