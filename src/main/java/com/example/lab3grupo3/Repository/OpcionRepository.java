package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Entity.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM opcion WHERE idopcion = ?1")
    Opcion obtenerOpcionById(int id);

}