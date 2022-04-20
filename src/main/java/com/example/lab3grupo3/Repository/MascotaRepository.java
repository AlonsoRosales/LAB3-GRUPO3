package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Entity.Cuenta;
import com.example.lab3grupo3.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    List<Mascota> findByCuentaIdcuenta(Cuenta cuenta);

}