package arrays;
import java.util.Arrays;

public class MatrixProduct {
    public static void main(String[] args) {
        //matrix1
        int[][] matrix1={
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("matrix 1 :");
        for(int[] row: matrix1){
            System.out.println(Arrays.toString(row));
        }

        //matrix2
        int[][] matrix2={
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };
        System.out.println("matrix 2 :");
        for(int[] row: matrix2){
            System.out.println(Arrays.toString(row));
        }

        //multiplication
        System.out.println("product of two matrix is :");
        int[][] result = multiplyMarices(matrix1, matrix2);
        for (int i = 0; i< 3; i++){
            for(int j = 0; j< 3; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMarices(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}
