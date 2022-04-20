package com.example.lab3grupo3.Repository;

import com.example.lab3grupo3.Dto.DuenoDto;
import com.example.lab3grupo3.Entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query(value = "select c.idcuenta as id,c.correo as correo, c.direccion as direccion, c.telefono as telefono, count(*) as cantidadMascotas from cuenta c\n" +
            "inner join mascota m on m.cuenta_idcuenta = c.idcuenta\n" +
            "group by c.idcuenta;", nativeQuery = true)
    public List<DuenoDto> listarDuenos();


}