package strings;

public class Performance {
    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            System.out.print(ch); // a b c d e ..... x y z
            // or
            series = series + ch;   //a new object is being created repeatedly, thats why we have a concept of stringbuilder
        }                           // it eats up a lot of space and have a TC of O(N^2)
        System.out.println();
        System.out.println(series);
    }
}
