import java.util.*;

public class NovaHeap {
    private int tail;
    private int[] heap;

    public NovaHeap(int capacidade) {
        this.heap = new int[capacidade];
        this.tail = -1;
    }
    
    public NovaHeap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int size() {
        return this.tail + 1;
    }
    
    public String toString() {
        return Arrays.toString(this.heap);
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return 2*index + 1;
    }

    public int right(int index) {
        return 2*index + 2;
    }

    public void add(int v) {
        if (this.tail >= (this.heap.length - 1)) resize();

        this.heap[++this.tail] = v;

        int i = this.tail;
        while (this.heap[parent(i)] < this.heap[i] & i > 0) {
            swap(i,parent(i));
            i = parent(i);
        }
    }

    public void buildHeap() {
        for (int i = parent(tail); i >= 0; i--)
            heapify(i);
    }

    public int remove() {
        if (isEmpty()) throw new RuntimeException("Empty");
        int elem = this.heap[0];
        this.heap[0] = this.heap[tail];
        this.tail--;

        this.heapify(0);

        return elem;
    }

    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) return;

        int max = maxIndex(index, left(index), right(index));

        if (max != index) {
            swap(index, max);
            heapify(max);
        }
    }
    
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private int maxIndex(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }
            return index;
        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            }
            return left;
        }
    }

    private void resize() {
        int[] newHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++)
            newHeap[i] = this.heap[i];

        this.heap = newHeap;
    }
}
