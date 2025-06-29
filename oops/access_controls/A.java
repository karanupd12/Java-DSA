package oops.access_controls;

public class A {
    //different access modifier are used on following data members
    private static int num;
    public static int num1;
    protected static String name;
    static String name1;
    int[] arr;

    public int getNum(){                  //getter for num
        return num;
    }

    public int setNum(){                  //setter for num
        this.num = num;
        return 0;
    }

    public int getNum1(){                  //getter for num1
        return num1;
    }

    public int setNum1(){                  //setter for num1
        this.num1 = num1;
        return 0;
    }

    public String getName(){                  //getter for name
        return name;
    }

    public String setName(){                  //setter for name
        this.name = name;
        return name;
    }

    public String getName1(){                     //getter for name1
        return name1;
    }

    public String setName1(){                     //setter for name1
        this.name1 = name1;
        return name1;
    }

    public A(int num, int num1 ,String name, String name1) {
        this.num = num;
        this.num1 = num1;
        this.name = name;
        this.name1 = name1;
        this.arr = new int [num];
    }
}
