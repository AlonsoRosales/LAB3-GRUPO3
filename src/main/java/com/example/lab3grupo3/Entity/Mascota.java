package com.example.lab3grupo3.Entity;

import com.example.lab3grupo3.Entity.Cuenta;
import com.example.lab3grupo3.Entity.RazaEspecie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mascota")
@Getter
@Setter
public class Mascota {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmascota", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "anho", nullable = false, length = 45)
    private String anho;

    @Lob
    @Column(name = "historia", nullable = false)
    private String historia;

    @Lob
    @Column(name = "observaciones", nullable = false)
    private String observaciones;

    @Column(name = "sexo", nullable = false, length = 45)
    private String sexo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "raza_especie_idraza", nullable = false)
    private RazaEspecie razaEspecie;

    @Column(name = "raza_otros", length = 45)
    private String razaOtros;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_idcuenta")
    private Cuenta cuenta;

}