package strings;
import java.util.Arrays;

public class Output {
    public static void main(String[] args) {
        System.out.println(56);

        System.out.println("karan");

        System.out.println(new int[]{1,2,3,4,5});  //I@12f40c25 this will print collection of [randow letter + @ + hashcode(12f40c25)] which is a "textual representation" of our object. This is because it use .toString by default .So, for printing the array in string we will use
        //Arrays.toString()
        System.out.println(Arrays.toString(new int[]{1,2,3,4,5}));  //[1,2,3,4,5]

        String name = null;
        System.out.println(name);
    }
}
