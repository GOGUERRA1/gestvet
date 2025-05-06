package com.example.gestvet.controller;

import com.example.gestvet.model.Evento;
import com.example.gestvet.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<Evento> crearEvento(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.crearEvento(evento));
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        return ResponseEntity.ok(eventoService.listarEventos());
    }
}