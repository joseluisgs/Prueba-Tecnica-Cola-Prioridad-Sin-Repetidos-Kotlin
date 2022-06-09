package es.dam.repositories;

import es.dam.models.Proceso;
import es.dam.tda.Cola;

import java.util.List;

public interface ColaPrioritaria extends Cola<Proceso> {
    List<Proceso> getAll();

    Proceso getById(int id);
}
