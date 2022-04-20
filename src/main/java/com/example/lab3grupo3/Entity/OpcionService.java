package com.example.lab3grupo3.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Getter
@Setter
@Embeddable
public class OpcionService implements Serializable {

    @Column(name="opcion_idopcion")
    private int opcionId;

    @Column(name="servicio_idservicio")
    private int servicioId;


}
