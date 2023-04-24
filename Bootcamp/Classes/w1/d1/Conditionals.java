package FullStack_IronHack.Bootcamp.Classes.w1.d1;

public class Conditionals{
    public static void main(String[] args){
        int var1 = 10;
        double var2 = 5.5;
        String var3 = "Hello World";

        // If...Else
        if(var1 > 10) {
            System.out.println("Too much!");
        } else if(var1 < 10) {
            System.out.println("Too little!");
        } else {
            System.out.println("Just right!");
        }

        // Switch
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");
                break;
        }

        // Ternary operators
        String result = day < 6? "Weekday": "Weekend";
        System.out.println(result);
    }
}
