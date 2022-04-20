package com.example.lab3grupo3.Entity;

import com.example.lab3grupo3.Entity.Cuenta;
import com.example.lab3grupo3.Entity.Mascota;
import com.example.lab3grupo3.Entity.Responsable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "servicio")
@Getter
@Setter
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idservicio", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "mascota_idmascota", nullable = false)
    private Mascota mascota;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cuenta_idcuenta", nullable = false)
    private Cuenta cuenta;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "hora_inicio", nullable = false)
    private LocalDateTime horaInicio;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "entrega", nullable = false)
    private String entrega;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "responsable_idresponsable", nullable = false)
    private Responsable responsable;


}