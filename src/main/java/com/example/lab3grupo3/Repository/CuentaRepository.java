package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}