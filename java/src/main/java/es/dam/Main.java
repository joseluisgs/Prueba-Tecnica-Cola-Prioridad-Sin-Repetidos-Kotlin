package es.dam;

import es.dam.controllers.ProcesosController;
import es.dam.errors.ProcesoException;
import es.dam.models.Proceso;
import es.dam.repositories.ColaPrioritaria;
import es.dam.repositories.ColaPrioritariaImp;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cola de prioridad sin repetidos");
        // Voy a meter valores
        ColaPrioritaria cola = new ColaPrioritariaImp();
        cola.push(new Proceso(1, "Proceso 1", 1));
        cola.push(new Proceso(2, "Proceso 2", 2));
        cola.push(new Proceso(3, "Proceso 3", 3));
        cola.push(new Proceso(4, "Proceso 4", 4));
        cola.push(new Proceso(5, "Proceso 5", 5));
        cola.push(new Proceso(1, "Proceso 1", 6));
        cola.push(new Proceso(2, "Proceso 2", 6));
        cola.push(new Proceso(8, "Proceso 8", 8));
        cola.push(new Proceso(9, "Proceso 9", 9));
        cola.push(new Proceso(4, "Proceso 4", 4));
        cola.push(new Proceso(5, "Proceso 5", 5));
        cola.push(new Proceso(10, "Proceso 10", 10));
        cola.push(new Proceso(11, "Proceso 11", -1));


        // Vamos a imprimir
        System.out.println("Imprimiendo cola");
        System.out.println(cola);

        // Ahora sacamos todos los valores
        System.out.println("Sacando todos los valores");
        while (!cola.isEmpty()) {
            System.out.println(cola.pop());
        }

        // Jugamos con el controlador
        System.out.println("Jugando con el controlador");
        var controlador = new ProcesosController(new ColaPrioritariaImp());
        System.out.println("Metiendo procesos");
        controlador.push(new Proceso(1, "Proceso 1", 8));
        controlador.push(new Proceso(2, "Proceso 2", 2));
        controlador.push(new Proceso(3, "Proceso 3", 3));

        System.out.println("Obteniendo Procesos");
        try {
            System.out.println("Proceso con id 1: " + controlador.getById(1));
            System.out.println("Proceso con id 3: " + controlador.getById(3));
        } catch (ProcesoException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Obteniendo todos Procesos");
        controlador.getAll().forEach(System.out::println);

        System.out.println("Sacando Procesos");
        while (!controlador.isEmpty()) {
            try {
                System.out.println(controlador.pop());
            } catch (ProcesoException e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println("Probado errores");
        try {
            System.out.println(controlador.pop());
        } catch (ProcesoException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(controlador.getById(1));
        } catch (ProcesoException e) {
            System.err.println(e.getMessage());
        }
    }
}