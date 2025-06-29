//WAP to count and List all the ways in which a maze(matrix form) can be completed by only going 1.right/down , 2.vertical/diagonal/horizontal.
//approach will be same as of subset/subsequence (processed(path) and unprocessed(rows and cols))

package recursion.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
        System.out.println(pathlist("", 3, 3));
        System.out.println(allpathlist("", 3, 3));
    }

    // count(only down and right)
    static int count(int rows, int cols) {
        if (rows == 1 || cols == 1) {
            return 1;
        }

        int down = count(rows - 1, cols);
        int right = count(rows, cols - 1);
        return down + right;
    }

    // 1.path-(only right and down)
    static ArrayList<String> pathlist(String p, int r, int c) {

        ArrayList <String> list = new ArrayList<>(); //creating an arraylist

        if (r == 1 && c == 1) {
            list.add(p);
            return list;
        }

        if (r > 1) { // if row increases, this means we have gone Down (now 1 row will be decreased in next call)
            list.addAll(pathlist(p + 'D', r - 1, c));
        }

        if (c > 1) { // if col increases, this means we have gone Right (now 1 col will be decreased in next call)
            list.addAll(pathlist(p + 'R', r, c - 1));
        }
        return list;
    }

    //1.path-(vertical,diagonal and horizontal)
    static ArrayList<String> allpathlist(String p, int r, int c) {

        ArrayList <String> list = new ArrayList<>(); //creating an arraylist

        if (r == 1 && c == 1) {
            list.add(p);
            return list;
        }

        if (r > 1) { // if row increases, this means we have gone vertical (now 1 row will be decreased in next call)
            list.addAll(allpathlist(p + 'V', r - 1, c));
        }

        if (r>1 && c>1){ //when going diagonal , both r and c increases (both will be reduced in next call)
            list.addAll(allpathlist(p + 'D', r - 1, c-1));
        }

        if (c > 1) { // if col increases, this means we have gone Right(horizontal)(now 1 col will be decreased in next call)
            list.addAll(allpathlist(p + 'H', r, c - 1));
        }
        return list;
    }
}
