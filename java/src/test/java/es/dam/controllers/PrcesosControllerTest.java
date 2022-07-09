package es.dam.controllers;

import es.dam.errors.ProcesoException;
import es.dam.models.Proceso;
import es.dam.repositories.ColaPrioritaria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrcesosControllerTest {
    @Mock
    private ColaPrioritaria repositorio;

    @InjectMocks
    private ProcesosController controller;

    @Test
    void push() {
        var p1 = new Proceso(1, "Proceso 1", 1);

        doNothing().when(repositorio).push(p1);

        var res = controller.push(p1);

        assertAll(
                () -> assertEquals(p1, res),
                () -> assertEquals(p1.getId(), res.getId())
        );

        verify(repositorio, times(1)).push(p1);
    }

    @Test
    void pop() throws ProcesoException {
        var p1 = new Proceso(1, "Proceso 1", 1);

        when(repositorio.pop()).thenReturn(p1);

        var res = controller.pop();

        assertAll(
                () -> assertEquals(p1, res),
                () -> assertEquals(p1.getId(), res.getId())
        );

        verify(repositorio, times(1)).pop();
    }

    @Test
    void popVacio() {

        when(repositorio.pop()).thenReturn(null);

        var res = assertThrows(ProcesoException.class, () -> controller.pop());
        assertEquals("No hay procesos en la cola", res.getMessage());

        verify(repositorio, times(1)).pop();
    }

    @Test
    void getById() throws ProcesoException {
        var p1 = new Proceso(1, "Proceso 1", 1);
        var lista = List.of(p1);

        when(repositorio.getById(p1.getId())).thenReturn(p1);

        var res = controller.getById(p1.getId());

        assertAll(
                () -> assertEquals(p1, res),
                () -> assertEquals(p1.getId(), res.getId())
        );

        verify(repositorio, times(1)).getById(p1.getId());
    }

    @Test
    void getByIdNoExiste() {
        var p1 = new Proceso(1, "Proceso 1", 1);

        when(repositorio.getById(p1.getId())).thenReturn(null);

        var res = assertThrows(ProcesoException.class, () -> controller.getById(p1.getId()));
        assertEquals("No hay proceso en la cola con id " + p1.getId(), res.getMessage());

        verify(repositorio, times(1)).getById(p1.getId());
    }

    @Test
    void getAll() {
        var p1 = new Proceso(1, "Proceso 1", 1);
        var lista = List.of(p1);

        when(repositorio.getAll()).thenReturn(lista);

        var res = controller.getAll();

        assertAll(
                () -> assertEquals(1, res.size()),
                () -> assertEquals(p1, res.get(0)),
                () -> assertEquals(1, res.get(0).getId())
        );

        verify(repositorio, times(1)).getAll();
    }
}