package es.dam.repositories;

import es.dam.models.Proceso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaPrioritariaImpTest {
    ColaPrioritaria repository;

    @BeforeEach
    public void setUpTes() {
        repository = new ColaPrioritariaImp();
    }

    @Test
    void push() {
        var p1 = new Proceso(1, "p1", 1);

        repository.push(p1);
        var res1 = repository.size();
        var item = repository.first();
        assertAll(
                () -> assertEquals(1, res1),
                () -> assertEquals(p1, item),
                () -> assertEquals(p1.getId(), item.getId()),
                () -> assertEquals(p1.getPrioridad(), item.getPrioridad())

        );
    }

    @Test
    void pushDuplicado() {
        var p1 = new Proceso(1, "p1", 1);
        var p2 = new Proceso(1, "p2", 5);

        repository.push(p1);
        repository.push(p2);
        var res1 = repository.size();
        var item = repository.first();
        assertAll(
                () -> assertEquals(1, res1),
                () -> assertEquals(p1, item),
                () -> assertEquals(p1.getId(), item.getId()),
                () -> assertEquals(p1.getPrioridad(), item.getPrioridad())
        );
    }

    @Test
    void pop() {
        var p1 = new Proceso(1, "p1", 1);

        repository.push(p1);
        var res1 = repository.size();
        var item = repository.pop();
        var res2 = repository.size();

        assertAll(
                () -> assertEquals(1, res1),
                () -> assertEquals(0, res2),
                () -> assertEquals(p1, item),
                () -> assertEquals(p1.getId(), item.getId()),
                () -> assertEquals(p1.getPrioridad(), item.getPrioridad())


        );
    }

    @Test
    void first() {
        var p1 = new Proceso(1, "p1", 1);
        var p2 = new Proceso(2, "p2", 6);

        repository.push(p1);
        repository.push(p2);

        var res = repository.first();

        assertAll(
                () -> assertNotEquals(p2, null),
                () -> assertEquals(p2, res),
                () -> assertEquals(p2.getId(), res.getId()),
                () -> assertEquals(p2.getPrioridad(), res.getPrioridad())
        );
    }

    @Test
    void isEmpty() {
        var p1 = new Proceso(1, "p1", 1);
        var res1 = repository.isEmpty();
        repository.push(p1);
        var res2 = repository.isEmpty();

        assertAll(
                () -> assertTrue(res1),
                () -> assertFalse(res2)
        );
    }

    @Test
    void size() {
        var p1 = new Proceso(1, "p1", 1);
        var res1 = repository.size();
        repository.push(p1);
        var res2 = repository.size();

        assertAll(
                () -> assertEquals(0, res1),
                () -> assertEquals(1, res2)
        );
    }

    @Test
    void popVacio() {
        var res = repository.pop();
        assertNull(res);
    }

    @Test
    void firstVacio() {
        var res = repository.first();
        assertNull(res);
    }

    @Test
    void isEmptyVacio() {
        var res = repository.isEmpty();
        assertTrue(res);
    }

    @Test
    void getAll() {
        var p1 = new Proceso(1, "p1", 1);
        var p2 = new Proceso(2, "p2", 6);

        repository.push(p1);
        repository.push(p2);

        var res = repository.getAll();

        assertAll(
                () -> assertNotEquals(p2, null),
                () -> assertEquals(p2, res.get(0)),
                () -> assertEquals(p2.getId(), res.get(0).getId()),
                () -> assertEquals(p2.getPrioridad(), res.get(0).getPrioridad()),
                () -> assertNotEquals(p1, null),
                () -> assertEquals(p1, res.get(1)),
                () -> assertEquals(p1.getId(), res.get(1).getId()),
                () -> assertEquals(p1.getPrioridad(), res.get(1).getPrioridad())
        );
    }

    @Test
    void getById() {
        var p1 = new Proceso(1, "p1", 1);
        var p2 = new Proceso(2, "p2", 6);

        repository.push(p1);
        repository.push(p2);

        var res1 = repository.getById(p1.getId());
        var res2 = repository.getById(p2.getId());

        assertAll(
                () -> assertNotEquals(p2, null),
                () -> assertEquals(p2.getId(), res2.getId()),
                () -> assertEquals(p2.getPrioridad(), res2.getPrioridad()),
                () -> assertNotEquals(p1, null),
                () -> assertEquals(p1.getId(), res1.getId()),
                () -> assertEquals(p1.getPrioridad(), res1.getPrioridad())
        );
    }

    void getByIdNoExiste() {

        var res1 = repository.getById(99);

        assertAll(
                () -> assertNull(res1)
        );
    }

}