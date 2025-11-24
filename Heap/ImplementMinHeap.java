import java.util.ArrayList;
import java.util.List;

public class ImplementMinHeap {
    private List<Integer> arr;
    private int count;

    public ImplementMinHeap(){
        arr = new ArrayList<>();
        count = 0;
    }

    public void heapifyUp(int index){
        int parent_index = (index - 1) / 2;

        if(index > 0 && arr.get(parent_index) > arr.get(index
        )){
            swap(arr, parent_index, index);
            heapifyUp(parent_index);
        }

        return;
    }

    public void heapifyDown(int index){
        int n = arr.size();
        int smallest = index;
        int leftChild_Ind = 2 * index + 1;
        int rightChild_Ind = 2 * index + 2;

        if(leftChild_Ind < n && arr.get(leftChild_Ind) < arr.get(smallest)){
            smallest = leftChild_Ind;
        }
        if(rightChild_Ind < n && arr.get(rightChild_Ind) < arr.get(smallest)){
            smallest = rightChild_Ind;
        }

        if(smallest != index){
            swap(arr, smallest, index);

            heapifyDown(smallest);
        }

        return;
    }

    public void initializeHeap() {
        arr.clear();
        count = 0;
    }

    public void insert(int key) {
        arr.add(key);
        count++;
        heapifyUp(count - 1);
        
        return;
    }

    public void changeKey(int index, int newVal) {
        if(arr.get(index) > newVal){
            arr.set(index, newVal);
            heapifyUp(index);
        } else {
            arr.set(index, newVal);
            heapifyDown(index);
        }

        return;
    }

    public void extractMin() {
        swap(arr, 0, count - 1);
        arr.remove(count - 1);
        count = count - 1;
        if(count > 0){
            heapifyDown(0);
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getMin() {
       return arr.get(0);
    }

    public int heapSize() {
        return count;
    }

    public void swap(List<Integer> arr, int a, int b){
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public static void main(String[] args) {
        // Creating an object of the Solution class
        ImplementMinHeap heap = new ImplementMinHeap();

        // Initializing a min heap data structure 
        heap.initializeHeap();
        
        // Performing different operations
        heap.insert(4); System.out.println("Inserting 4 in the min-heap");
        heap.insert(5); System.out.println("Inserting 5 in the min-heap");
        heap.insert(10); System.out.println("Inserting 10 in the min-heap");
        System.out.println("Minimum value in the min-heap is: " + heap.getMin());
        System.out.println("Size of min-heap is: " + heap.heapSize());
        System.out.println("Is heap empty: " + heap.isEmpty());
        System.out.println("Extracting minimum value from the heap");
        heap.extractMin();
        System.out.println("Changing value at index 0 to 10");
        heap.changeKey(0, 10);
        System.out.println("Minimum value in the min-heap is: " + heap.getMin());
    }
}
