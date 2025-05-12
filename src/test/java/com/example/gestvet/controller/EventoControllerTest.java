package com.example.gestvet.controller;

import com.example.gestvet.model.Evento;
import com.example.gestvet.service.EventoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EventoController.class)
public class EventoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventoService eventoService;

    @Test
    void testListarEventos() throws Exception {
        Evento evento = new Evento();
        evento.setId(1L);
        evento.setNombre("Feria de Mascotas");
        evento.setFecha(LocalDate.of(2025, 6, 1));
        evento.setLugar("Plaza Central");

        when(eventoService.listarEventos()).thenReturn(Collections.singletonList(evento));

        mockMvc.perform(get("/api/eventos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Feria de Mascotas"));
    }
}
