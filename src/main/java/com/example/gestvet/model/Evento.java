package com.example.gestvet.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private LocalDate fecha;
    private String lugar;

    // Getters y Setters 
}
