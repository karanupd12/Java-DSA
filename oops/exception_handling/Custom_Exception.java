package oops.exception_handling;

public class Custom_Exception extends Exception{

    public Custom_Exception(String message) {
        super(message);
    }

    public static void main(String[] args) {

        try{
            String name = "Cristiano Ronaldo";
            if (name.equals("Cristiano Ronaldo")){
                throw new Custom_Exception("Cristiano Ronaldo caught !!");
            }
        }
        catch (Custom_Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("a madrid legend ");
        }
    }
}
