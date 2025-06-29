import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int n = arr.length;
        int h = 1;

        // Generate the gap sequence
        while (h < n / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121...
        }

        // Shell sort
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    swap(arr, j, j - h);
                }
            }
            h = h / 3; // Reduce the gap
        }
    }

    // Swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = {
            105, 3, -45, 0, 78, 256, -500, 89, 6, 47, 120, -1, 95, 203, 402, 8, 67, -305, 0, 78, 63, 7, 402,
            -89, 64, 1000, 523, -99, 700, 8, 150, -76, 95, 32, 3, 400, 222, -100, 76, 89, 54, 45, -45, 900, 
            200, 601, 803, -300, 400, 2, 1, 67, 900, 0, 110, -405, 56, 8, 45, 999, -1, 76, 77, 400, 45, -200
        };

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(testArray));

        shellSort(testArray);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(testArray));
    }
}
