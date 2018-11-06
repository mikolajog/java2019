package java2015.domain;

import java.util.ArrayList;

public class Heap {

	private int heapSize = 0;
	private ArrayList<Double> tab = new ArrayList<>();

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public ArrayList<Double> getTab() {
        return tab;
    }

    public void setTab(ArrayList<Double> tab) {
        this.tab = tab;
    }

    public void insert(double value) {
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
		return tab.get(currentIndex) > tab.get(parentIndex);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		Double parentValue = tab.get(parentIndex);
		Double currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public Double parentValue(int currentIndex) {
		Double parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
		return heapSize ;
	}

	public double top() {
		return tab.get(0);
	}

	public void maxHeapify(int index){
		int l = (index*2) + 1;
		int r = (index*2) + 2;
		int largest = index;

		if (l<heapSize && tab.get(l)>tab.get(index)){
			largest = l;

		}

		if (r<heapSize && tab.get(r)>tab.get(largest)){
			largest = r;
		}

		if(largest != index){
			swapElements(index, largest);
			maxHeapify(largest);
		}
	}

	public double extractMax(){
		if(tab.size()<1){
			return 0.0;
		}

		double max = top();
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

	public double replace(double replacement){
		if(tab.size()<1){
			return 0.0;
		}
		double max = top();
		tab.set(0, replacement);
		maxHeapify(0);
		return max;
	}

	public void heapify(ArrayList<Double> heap){
		tab = (ArrayList<Double>) heap.clone();
		heapSize = heap.size();
		for(int i=heapSize/2; i>=0; i--){
			maxHeapify(i);
		}
	}

	public void meld(ArrayList<Double> heap){

		for(double x:heap){
			tab.add(x);
		}
		heapSize += heap.size();
		for(int i=heapSize/2; i>=0; i--){
			maxHeapify(i);
		}
	}

	public Heap merge(Heap heap){
		Heap result = new Heap();
		result.tab = (ArrayList<Double>)this.tab.clone();
		result.heapSize = result.tab.size();
		for(double x:heap.tab){
			result.tab.add(x);
		}
		result.heapSize += heap.size();
		for(int i=result.heapSize/2; i>=0; i--)
		{
			result.maxHeapify(i);
		}
		return result;
	}
}
