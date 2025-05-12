package com.example.gestvet.service;

import com.example.gestvet.model.Participante;
import com.example.gestvet.repository.ParticipanteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParticipanteServiceTest {

    @Mock
    private ParticipanteRepository participanteRepository;

    @InjectMocks
    private ParticipanteService participanteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void inscribirParticipante_deberiaGuardarYRetornarParticipante() {
        Participante p = new Participante();
        p.setNombreMascota("Firu");
        p.setDueno("Pedro");

        when(participanteRepository.save(p)).thenReturn(p);

        Participante resultado = participanteService.inscribirParticipante(p);

        assertNotNull(resultado);
        assertEquals("Firu", resultado.getNombreMascota());
        verify(participanteRepository, times(1)).save(p);
    }

    @Test
    void buscarParticipantePorId_deberiaRetornarParticipante() {
        Participante p = new Participante();
        p.setId(1L);
        p.setNombreMascota("Firu");
        p.setDueno("Pedro");

        when(participanteRepository.findById(1L)).thenReturn(Optional.of(p));

        Participante resultado = participanteService.buscarParticipantePorId(1L);

        assertNotNull(resultado);
        assertEquals("Firu", resultado.getNombreMascota());
        verify(participanteRepository, times(1)).findById(1L);
    }
}
