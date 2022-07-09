package es.dam.controllers;

import es.dam.errors.ProcesoException;
import es.dam.models.Proceso;
import es.dam.repositories.ColaPrioritaria;

import java.util.List;

/**
 * Ejemplo de controlador de procesos
 * Se aplica Inyección de dependencias por constructor
 */
public class ProcesosController {
    ColaPrioritaria repositorio;

    public ProcesosController(ColaPrioritaria repositorio) {
        this.repositorio = repositorio;
    }

    public Proceso push(Proceso proceso) {
        repositorio.push(proceso);
        return proceso;
    }

    public Proceso pop() throws ProcesoException {
        var res = repositorio.pop();
        if (res == null) {
            throw new ProcesoException("No hay procesos en la cola");
        } else {
            return res;
        }
    }

    public Proceso getById(int id) throws ProcesoException {
        var res = repositorio.getById(id);
        if (res == null) {
            throw new ProcesoException("No hay proceso en la cola con id " + id);
        } else {
            return res;
        }
    }

    public boolean isEmpty() {
        return repositorio.isEmpty();
    }

    public List<Proceso> getAll() {
        return repositorio.getAll();
    }
}
