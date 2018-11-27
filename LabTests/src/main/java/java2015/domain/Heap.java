package java2015.domain;

import java.util.ArrayList;
import java.util.Comparator;



public class Heap<T> {

	private int heapSize = 0;
	private Comparator comparator;
	private ArrayList<T> tab = new ArrayList<>();

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public void setComparator (Comparator comparator){
    	this.comparator = comparator;
	}

    public ArrayList<T> getTab() {
        return tab;
    }

    public void setTab(ArrayList<T> tab) {
        this.tab = tab;
    }

    public void insert(T value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
		return(comparator.compare(tab.get(currentIndex),tab.get(parentIndex))==1);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		T parentValue = tab.get(parentIndex);
		T currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public T parentValue(int currentIndex) {
		T parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
		return heapSize ;
	}

	public T top() {
		return tab.get(0);
	}

	public void maxHeapify(int index){
		int l = (index*2) + 1;
		int r = (index*2) + 2;
		int largest = index;

		if (l<heapSize &&comparator.compare(tab.get(l),tab.get(index))==1){
			largest = l;

		}

		if (r<heapSize &&comparator.compare(tab.get(r),tab.get(largest))==1){
			largest = r;
		}

		if(largest != index){
			swapElements(index, largest);
			maxHeapify(largest);
		}
	}

	public T extractMax(){
		if(tab.size()<1){
			return null;
		}

		T max = top();
		tab.set(0, tab.get(heapSize-1));
		tab.remove(heapSize-1);
		heapSize--;
		maxHeapify(0);
		return max;
	}

	public void deleteMax(){
		if(tab.size()<1){
			return ;
		}
		tab.set(0, tab.get(heapSize-1));
		tab.remove(heapSize-1);
		heapSize--;
		maxHeapify(0);
	}

	public T replace(T replacement){
		if(tab.size()<1){
			return replacement;
		}
		T max = top();
		tab.set(0, replacement);
		maxHeapify(0);
		return max;
	}

	public void heapify(ArrayList<T> heap){
		tab = (ArrayList<T>) heap.clone();
		heapSize = heap.size();
		for(int i=heapSize/2; i>=0; i--){
			maxHeapify(i);
		}
	}

	public void meld(ArrayList<T> heap){

		for(T x:heap){
			tab.add(x);
		}
		heapSize += heap.size();
		for(int i=heapSize/2; i>=0; i--){
			maxHeapify(i);
		}
	}

	public Heap merge(Heap heap){
		Heap result = new Heap();
		result.tab = (ArrayList<T>) this.tab.clone();
		result.heapSize = result.tab.size();
		result.tab.addAll(heap.tab);
		result.heapSize += heap.size();
		for(int i=result.heapSize/2; i>=0; i--)
		{
			result.maxHeapify(i);
		}
		return result;
	}
}
