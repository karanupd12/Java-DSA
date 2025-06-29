//Input: area = 4
//Output: [2,2]

//Input: area = 122122
//Output: [427,286]


package math;

public class Rectangle {
    public int[] constructRectangle(int area) {
        return constructRectangleHelper(area, 1, new int[2]);
    }

    private int[] constructRectangleHelper(int area, int length, int[] arr) {
        if (length > Math.sqrt(area)) {
            return arr;
        }
        int width = area / length;

        if (width * length == area && (arr[0] == 0 || Math.abs(length - width) < Math.abs(arr[0] - arr[1]))) {
            arr[0] = Math.max(length, width);
            arr[1] = Math.min(length, width);
        }
        return constructRectangleHelper(area, length + 1, arr);
    }
}
