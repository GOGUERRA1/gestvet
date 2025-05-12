package com.example.gestvet.service;

import com.example.gestvet.model.Evento;
import com.example.gestvet.repository.EventoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventoServiceTest {

    @Mock
    private EventoRepository eventoRepository;

    @InjectMocks
    private EventoService eventoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearEvento_deberiaGuardarYRetornarEvento() {
        Evento evento = new Evento();
        evento.setNombre("Feria Animal");
        evento.setTipo("feria");
        evento.setFecha(LocalDate.now());
        evento.setLugar("Plaza");

        when(eventoRepository.save(evento)).thenReturn(evento);

        Evento resultado = eventoService.crearEvento(evento);

        assertNotNull(resultado);
        assertEquals("Feria Animal", resultado.getNombre());
        verify(eventoRepository, times(1)).save(evento);
    }

    @Test
    void listarEventos_deberiaRetornarListaDeEventos() {
        Evento e1 = new Evento();
        Evento e2 = new Evento();
        when(eventoRepository.findAll()).thenReturn(Arrays.asList(e1, e2));

        List<Evento> eventos = eventoService.listarEventos();

        assertEquals(2, eventos.size());
        verify(eventoRepository, times(1)).findAll();
    }
}