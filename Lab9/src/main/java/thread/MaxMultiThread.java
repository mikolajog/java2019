package thread;


import random.GenerateRandoms;

import java.io.File;

import java.io.PrintWriter;
import java.util.Scanner;

public class MaxMultiThread implements Runnable {

    private String nazwaPliku;

    public MaxMultiThread(String nazwa){
        nazwaPliku = nazwa;
    }

    public void run () {

        try {
            PrintWriter writer = new PrintWriter(new File("/home/mikolaj/Desktop/" + nazwaPliku + ".txt"));
            writer.print("");
            writer.close();
            Kwadratowa o1 = new Kwadratowa();

            GenerateRandoms g1 = new GenerateRandoms(nazwaPliku);
            Thread thread = new Thread(g1);
            thread.start();
            Scanner odczyt = new Scanner(new File("/home/mikolaj/Desktop/" + nazwaPliku + ".txt"));
            String sentence;
            while (true) {
                System.out.println("Odczytuje");
                sentence = odczyt.nextLine();
                System.out.println(o1.function(sentence));
                Thread.sleep(10);
            }

        }
        catch (InterruptedException e){}
        catch (java.io.FileNotFoundException a){}
    }

}




