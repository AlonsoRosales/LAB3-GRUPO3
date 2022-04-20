package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}