package com.example.lab3grupo3.Entity;

import com.example.lab3grupo3.Entity.Opcion;
import com.example.lab3grupo3.Entity.Servicio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "opcion_servicio")
@Getter
@Setter
public class OpcionServicio {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private OpcionService id;

    @ManyToOne
    @MapsId("opcionId")
    @JoinColumn(name = "opcion_idopcion", nullable = false)
    private Opcion opcion;

    @ManyToOne
    @MapsId("servicioId")
    @JoinColumn(name = "servicio_idservicio", nullable = false)
    private Servicio servicio;

}