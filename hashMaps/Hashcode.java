package hashMaps;

public class Hashcode {
    public static void main(String[] args) {

        //hashcode() function takes an input of any type and length and converts it into a unique integer called hashcode
        String name = "Karan";
        int code1 = name.hashCode();
        System.out.println(code1);     // 72266473

        Boolean b = true;
        int code2 = b.hashCode();
        System.out.println(code2);     // 1231
    }
}
