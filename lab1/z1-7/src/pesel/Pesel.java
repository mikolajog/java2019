package pesel;

import javaIn.*;

public class Pesel {
    String pesel;

    public void wczytaj(){
        System.out.print("Podaj swoj pesel:");
        pesel = JIn.getString();
    }

    public static void check(String pesel){
       // 9×a + 7×b + 3×c + 1×d + 9×e + 7×f + 3×g + 1×h + 9×i + 7×j
        int score = (Character.getNumericValue(pesel.charAt(0))*9) + (Character.getNumericValue(pesel.charAt(1))*7) +
                (Character.getNumericValue(pesel.charAt(2))*3) + (Character.getNumericValue(pesel.charAt(3))*1) + (Character.getNumericValue(pesel.charAt(4))*9) +
                (Character.getNumericValue(pesel.charAt(5))*7) + (Character.getNumericValue(pesel.charAt(6))*3) + (Character.getNumericValue(pesel.charAt(7))*1) +
                (Character.getNumericValue(pesel.charAt(8))*9) + (Character.getNumericValue(pesel.charAt(9))*7);

        if(score%10 == Character.getNumericValue(pesel.charAt(10)))
        {
            System.out.println("Pesel OK");
        }
        else
        {
            System.out.println("Pesel ZŁY");
        }
    }
}
