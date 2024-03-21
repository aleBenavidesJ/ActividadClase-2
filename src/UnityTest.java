import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class UnityTest {
    @Test
    public void testIterator1() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIterator2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        Iterator<Integer> iterator = list.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
    }

    @Test
    public void testIterator3() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.remove();
        assertEquals(2, list.size());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
    }
    /* No sé si había que hacerle las pruebas al iterador pero de igual manera las hice para no perder puntos jaja
     Pero me gustaría saber si es necesario hacerle dichas pruebas al iterador, ya que desde mi punto de vista y entendimiento
     el iterador se implementa en las otras listas, entonces a lo que yo masomenos entiendo se prueba "indirectamente" que sí
     funciona con las pruebas hechas a las otras listas.
     Basicamente, mi pregunta es: si es o no necesario hacerle las pruebas, y de serlo por qué? */

    @Test
    public void testInsertList1() {
        LinkedList<Integer> original = new LinkedList<>();
        LinkedList<Integer> add = new LinkedList<>();
        add.insert(5);
        add.insert(6);
        add.insert(7);
        add.insert(8);
        original.insert(1);
        original.insert(2);
        original.insert(3);
        original.insert(4);
        original.insertList(add);
        assertEquals(8, original.size());
    }

    @Test
    public void testInsertList2() {
        LinkedList<Integer> original = new LinkedList<>();
        LinkedList<Integer> add = new LinkedList<>();
        add.insert(5);
        add.insert(6);
        add.insert(7);
        add.insert(8);
        original.insertList(add);
        assertEquals(4, original.size());
        assertEquals(5, original.get(0));
        assertEquals(6, original.get(1));
        assertEquals(7, original.get(2));
        assertEquals(8, original.get(3));
    }

    @Test
    public void testInsertList3() {
        LinkedList<Integer> original = new LinkedList<>();
        LinkedList<Integer> add = new LinkedList<>();
        original.insert(1);
        original.insert(2);
        original.insert(3);
        original.insert(4);
        original.insertList(add);
        assertEquals(4, original.size());
        assertEquals(1, original.get(0));
        assertEquals(2, original.get(1));
        assertEquals(3, original.get(2));
        assertEquals(4, original.get(3));
    }

    @Test
    public void testSubList1() {
        LinkedList<Integer> original = new LinkedList<>();
        original.insert(1);
        original.insert(2);
        original.insert(3);
        original.insert(4);
        LinkedList<Integer> newList = original.subList(1, 2);
        assertEquals(2, newList.size());
        assertEquals(2, newList.get(0));
        assertEquals(3, newList.get(1));
    }

    @Test
    public void testSubList2() {
        LinkedList<Integer> original = new LinkedList<>();
        original.insert(1);
        original.insert(2);
        original.insert(3);
        original.insert(4);
        LinkedList<Integer> newList = original.subList(0, 4);
        assertEquals(4, newList.size());
        assertEquals(1, newList.get(0));
        assertEquals(2, newList.get(1));
        assertEquals(3, newList.get(2));
        assertEquals(4, newList.get(3));
    }

    @Test
    public void testSubList3() {
        LinkedList<Integer> original = new LinkedList<>();
        original.insert(1);
        original.insert(2);
        original.insert(3);
        original.insert(4);
        LinkedList<Integer> newList = original.subList(2, 0);
        assertEquals(0, newList.size());
    }

    @Test
    public void testReverse1() {
        LinkedList<Integer> original = new LinkedList<>();
        original.insert(1);
        original.insert(2);
        original.insert(3);
        original.insert(4);
        original.reverse();
        assertEquals(4, original.get(0));
        assertEquals(3, original.get(1));
        assertEquals(2, original.get(2));
        assertEquals(1, original.get(3));
    }

    @Test
    public void testReverse2() {
        LinkedList<Integer> original = new LinkedList<>();
        original.reverse();
        assertEquals(0, original.size());
    }

    @Test
    public void testReverse3() {
        LinkedList<Integer> original = new LinkedList<>();
        original.insert(1);
        original.reverse();
        assertEquals(1, original.size());
        assertEquals(1, original.get(0));
    }
}