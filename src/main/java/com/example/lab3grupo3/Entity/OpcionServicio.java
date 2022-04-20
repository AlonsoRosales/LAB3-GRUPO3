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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idopcion_servicio", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "opcion_idopcion", nullable = false)
    private Opcion opcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "servicio_idservicio", nullable = false)
    private Servicio servicio;

}