package java2015.main;

import org.junit.Test;
import java2015.domain.Heap;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void insert0And2And3And6And1intoNewHeap_extractMaxIs6() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(6);
        heap.insert(1);

        assertEquals(6,heap.extractMax(), 0);
        assertEquals(3,heap.extractMax(), 0);

    }

    @Test
    public void insert0And2And3And6And1intoNewHeap_deleteMax_extractMaxIs3() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(6);
        heap.insert(1);

        heap.deleteMax();

        assertEquals(3,heap.top(), 0);
    }

    @Test
    public void insert0And2And3And6And1intoNewHeap_replace_extractMaxIs3() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(6);
        heap.insert(1);

        double rep = heap.replace(10);

        assertEquals(6,rep, 0);
        assertEquals(10,heap.extractMax(), 0);
    }

    @Test
    public void checkHeapify() {

        ArrayList<Double> heap = new ArrayList<>();
        heap.add(1.0);
        heap.add(8.0);
        heap.add(9.0);
        heap.add(3.0);

        Heap heap1 = new Heap();
        heap1.heapify(heap);

        assertEquals(9,heap1.extractMax(), 0);
    }

    @Test
    public void checkMeld() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(6);
        heap.insert(1);

        ArrayList<Double> heap1 = new ArrayList<>();
        heap1.add(1.0);
        heap1.add(8.0);
        heap1.add(11.0);
        heap1.add(3.0);

        heap.meld(heap1);

        assertEquals(11,heap.extractMax(), 0);
        assertEquals(8,heap.extractMax(), 0);
        assertEquals(6,heap.extractMax(), 0);
        assertEquals(3,heap.extractMax(), 0);
        assertEquals(3,heap.extractMax(), 0);
    }

    @Test
    public void checkMerge() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(6);
        heap.insert(1);

        Heap heap1 = new Heap();
        heap1.insert(1.0);
        heap1.insert(8.0);
        heap1.insert(11.0);
        heap1.insert(3.0);

        Heap res = heap.merge(heap1);

        assertEquals(11,res.extractMax(), 0);
        assertEquals(8,res.extractMax(), 0);
        assertEquals(6,res.extractMax(), 0);
        assertEquals(3,res.extractMax(), 0);
        assertEquals(3,res.extractMax(), 0);
    }
}
