package java2015.domain;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class HeapTest {

	public class DoubleComparator<T> implements Comparator<T> {
		@Override
		public int compare(T x, T y){
			if((Double)x<(Double)y){
				return -1;
			}
			if((Double)x>(Double)y){
				return 1;
			}
			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			return ((Double)obj).equals(this);
		}
	}
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap<Double>();
		heap.setComparator(new DoubleComparator());
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,(Double) heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2.0,(Double)heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,(Double)heap.top(),0.001);

	}


}
