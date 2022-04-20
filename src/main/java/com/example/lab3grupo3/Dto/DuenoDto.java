package com.example.lab3grupo3.Dto;

import javax.persistence.criteria.CriteriaBuilder;

public interface DuenoDto {

    Integer getId();
    String getCorreo();
    String getDireccion();
    String getTelefono();
    Integer getCantidadMascotas();

}
