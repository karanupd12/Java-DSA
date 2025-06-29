import java.awt.dnd.InvalidDnDOperationException;
import java.util.Arrays;

public class CountSort {

    public static void countSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        //step 1 : find max element
        int max = Arrays.stream(array).max().getAsInt();

        //create a frequency array of size max+1 //num is index itself
        int[] freqArray = new int[max + 1];
        for (int num : array){
            freqArray[num]++;
        }

        //making a sorted array of nums whose freq > 0
        int index = 0;
        for (int i = 0; i<= max; i++){
            while(freqArray[i]>0){
                array[index] = i;
                index++;
                freqArray[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 10, 9, 2, 4, 9, 7};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
