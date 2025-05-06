package com.example.gestvet.repository;

import com.example.gestvet.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {}
