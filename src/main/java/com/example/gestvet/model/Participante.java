package com.example.gestvet.model;

import jakarta.persistence.*;

@Entity
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreMascota;
    private String dueno;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Getters y Setters   
}
