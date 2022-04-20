package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {
    @Query(nativeQuery = true,value = "select responsable.* from responsable \n" +
            "inner join servicio on servicio.responsable_idresponsable=responsable.idresponsable\n" +
            "inner join mascota on servicio.mascota_idmascota = mascota.idmascota\n" +
            "where mascota.idmascota=?1")
    List<Responsable> responsablespormascota(int idmascota);
}