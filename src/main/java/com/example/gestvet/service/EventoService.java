package com.example.gestvet.service;

import com.example.gestvet.model.Evento;
import com.example.gestvet.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepo;

    public Evento crearEvento(Evento evento) {
        return eventoRepo.save(evento);
    }

    public List<Evento> listarEventos() {
        return eventoRepo.findAll();
    }
}