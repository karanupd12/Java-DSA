package search.leetcodeques;

public class CountNegatives {
    public static int countNegatives(int[][] grid) {
        //LINEAR SEARCH
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j< grid[i].length; j++){
                if (grid[i][j] < 0){
                    count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[][] grid = {{5,1,0},{-5,-5,-5}};
        System.out.println(countNegatives(grid));
    }
}
