import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr){
        //max element
        int max = Arrays.stream(arr).max().getAsInt();
        //do count sort for every digit place
        for(int exp = 1;  max/exp > 0; exp *= 10){ //if max is like "894" , it will run 3 times (total no of digits max has)
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int arr[], int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);
        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        // Change count[i] so that count[i] now contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        // Copy the output array to arr[] so that arr[] contains sorted numbers
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {28, 83, 471, 36, 91, 8};
        System.out.println("Orignal array : "+ Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted Array : "+ Arrays.toString(arr));
    }
}
