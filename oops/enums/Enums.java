package oops.enums;

public class Enums {

    enum SystemStatus {
        Success, Running, Failing, Error, Timeout, unauthorized;

        SystemStatus() {         //constructor for status
        }
    }

    public static void main(String[] args) {
        SystemStatus status1 = SystemStatus.Success;
        SystemStatus status2 = SystemStatus.Error;
        SystemStatus status3 = SystemStatus.Timeout;
        SystemStatus status4 = SystemStatus.Running;
        System.out.println(status1);
        System.out.println(status2);
        System.out.println(status3);

        //supports swich - case
        switch (status4){
            case Error -> System.out.println("Error in System");
            case Running -> System.out.println("System is running");
        }

        //supports iteration - enhanced for loop
        SystemStatus[] statuses = SystemStatus.values();
        for(SystemStatus status : statuses){
            System.out.print(status.ordinal() + "-" + status + " ");   //return var index - name
        }

    }
}