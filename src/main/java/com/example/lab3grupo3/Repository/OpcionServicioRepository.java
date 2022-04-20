package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Entity.OpcionService;
import com.example.lab3grupo3.Entity.OpcionServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionServicioRepository extends JpaRepository<OpcionServicio, OpcionService> {

    @Query(nativeQuery = true,value = "SELECT * FROM opcion_servicio INNER JOIN opcion ON (opcion.idopcion = opcion_servicio.opcion_idopcion) INNER JOIN servicio ON ( servicio.idservicio = opcion_servicio.servicio_idservicio) INNER JOIN responsable ON ( responsable.idresponsable = servicio.responsable_idresponsable) WHERE idopcion_servicio = ?1")
    OpcionServicio buscarOpcionServicio(int id);
}
