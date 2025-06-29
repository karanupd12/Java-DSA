//this code is to understand the implementation of both shallow and deep copy

package oops.cloning;
import java.util.Arrays;

public class Human2 implements Cloneable{
    int[] arr;
    String name;
    int age;

    public Human2(String name, int age) {
        this.name = name;
        this.age = age;
        this.arr = new int[]{3, 4, 5, 6, 9, 1};
    }

    public Object clone() throws CloneNotSupportedException{

        //this is shallow copy in which twin only copies the reference variable from Human2 not the object itself
        // the reference variable(name , age) of twin points towards the object of Human2(karan , 18)
        Human2 twin = (Human2)super.clone();

        //this is deep copy in which a new object is formed , both reference variable along with object is copied from Human2 into twin
        twin.arr = new int[twin.arr.length];
        for(int i = 0; i< twin.arr.length; i++){
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Human2 karan = new Human2("karan" , 19);
        Human2 twin = (Human2)karan.clone();
        System.out.println(twin.name + " " + twin.age);

        System.out.println(Arrays.toString(twin.arr));
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(twin.arr));
    }
}
