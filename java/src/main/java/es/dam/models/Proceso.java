package es.dam.models;

import java.util.Objects;

/**
 * POJO class for Process.
 * Se implementa los métodos hashCode, equals y toString.
 */
public class Proceso {
    private int id;
    private String nombre;
    private int prioridad;

    public Proceso(int id, String nombre, int prioridad) {;
        this.id = id;
        this.nombre = nombre;
        if (prioridad < 1) {
            this.prioridad = 1;
        } else this.prioridad = Math.min(prioridad, 9);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", name='" + nombre + '\'' +
                ", priority=" + prioridad +
                '}';
    }
}
