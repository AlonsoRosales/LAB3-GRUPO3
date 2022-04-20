package com.example.lab3grupo3.Entity;

import javax.persistence.*;

@Entity
@Table(name = "opcion")
public class Opcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idopcion", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

    @Column(name = "tiempo_minutos", nullable = false)
    private Integer tiempoMinutos;

    @Column(name = "precio", nullable = false)
    private Double precio;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getTiempoMinutos() {
        return tiempoMinutos;
    }

    public void setTiempoMinutos(Integer tiempoMinutos) {
        this.tiempoMinutos = tiempoMinutos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}