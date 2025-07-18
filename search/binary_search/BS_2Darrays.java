package search.binary_search;
import java.util.Arrays;

public class BS_2Darrays {
    public static void main(String[] args) {
        int[][] arr = {
                { 20, 25, 30 },
                { 40, 45, 50 },
                { 60, 65, 70 }
        };
        int target = 70;
        System.out.println(Arrays.toString(binarysearch2D(arr , target)));
    }

    static int[] binarysearch(int[][] matrix, int row, int cStart, int cEnd, int target) {

        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[] { row, mid };
            }
            else if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1 , -1};
    }

    static int[] binarysearch2D(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;     // be cautious , matrix may be empty

        if (rows == 1) {
            return binarysearch(matrix, 0, 0, cols-1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols/2;

        //run the loop till two rows are remaining
        while(rStart < (rEnd - 1)){ //while this is true , it will have more than 2 rows
            int mid = rStart + (rEnd - rStart) / 2;
            if(matrix[mid][cMid] == target){
                return new int[] {mid , cMid};
            }
            else if (matrix[mid][cMid] < target) {
                rStart = mid;
            }else {
                rEnd = mid;
            }
        }

        //now we have 2 rows
        //check whether the target is in column of 2 rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart , cMid};
        }

        if (matrix[rStart + 1][cMid] == target) {
            return new int[] {rStart , cMid};
        }

        // search in 1st half
        if (target <= matrix[rStart][cMid - 1]){
            return binarysearch(matrix, rStart, 0, cMid-1, target);
        }

        // search in 2nd half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols-1]){
            return binarysearch(matrix, rStart, cMid+1, cols-1, target);
        }

        // search in 3rd half
        if (target <= matrix[rStart + 1][cMid - 1]){
            return binarysearch(matrix, rStart+1, 0, cMid-1, target);
        }
        // search in 4th half
        else{
            return binarysearch(matrix, rStart+1, cMid+1, cols-1, target);
        }
    }
}
