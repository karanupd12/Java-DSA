package heaps;
import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;
    public Heap(){
        list = new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int i){
        return (i-1)/2;
    }
    private int left(int i){
        return (2*i+1);
    }
    private int right(int i){
        return (2*i+2);
    }
    public int size(){return list.size();}

    //INSERTION
    public void insert(T value){
        list.add(value);
        //upheap from the last index
        upheap(list.size() - 1);
    }
    private void upheap(int i) {
        //we reached root
        if (i == 0){
            return;
        }
        int p = parent(i);
        if(list.get(i).compareTo(list.get(p)) < 0){
            swap(i , p);
            upheap(p);
        }
    }

    //DELETION
    public T remove() throws Exception{
        if (list.isEmpty()){
            throw new Exception("Removing from an empty heap!");
        }
        T temp = list.get(0);
        T last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }
    private void downheap(int i) {
        //we reached root
        if (i == list.size()-1){
            return;
        }
        int min = i;
        int left = left(i);
        int right = right(i);

        if ( left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }
        if ( right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }
        if (min != i){
            swap(min, i);
            downheap(min);
        }
    }

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);

        System.out.println(heap.remove());
        System.out.println(heap.remove());
    }
}
