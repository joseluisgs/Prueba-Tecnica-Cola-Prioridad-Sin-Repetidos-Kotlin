package es.dam.repositories;

import es.dam.models.Proceso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Cola Prioritaria sin elementos repetidos en base al id
 * He priorizado el orden solo en las consultas, porque en mi supuesto
 * ordenar en cada insercción puede ser costoso
 * aun así se debe analizar las frecuencias de insercciones sobre consultas
 * por si es mas eficiente usar un TreeSet con el orden prestablecido
 */
public class ColaPrioritariaImp implements ColaPrioritaria {
    private List<Proceso> items = new ArrayList<>();

    @Override
    public void push(Proceso item) {
        // Comprobamos si el elemento ya existe en base a su id
        if (items.stream().noneMatch(p -> p.getId() == item.getId())) {
            items.add(item);
        }
    }

    @Override
    public Proceso pop() {
        var res = getMax();
        items.remove(res);
        return res;
    }

    private Proceso getMax() {
        return items.stream().max(Comparator.comparingInt(Proceso::getPrioridad)).orElse(null);
    }


    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public List<Proceso> getAll() {
        return items.stream()
                .sorted(Comparator.comparingInt(Proceso::getPrioridad).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Proceso getById(int id) {
        return items.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
