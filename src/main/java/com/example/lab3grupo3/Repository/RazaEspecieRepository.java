package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Entity.RazaEspecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazaEspecieRepository extends JpaRepository<RazaEspecie, Integer> {
}