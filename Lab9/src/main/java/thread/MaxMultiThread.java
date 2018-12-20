package thread;


import random.GenerateRandoms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxMultiThread {

    private String nazwaPliku;

    public MaxMultiThread(String nazwa){
        nazwaPliku = nazwa;
    }

    public void obliczaj(IHaveFunction o1)throws FileNotFoundException, InterruptedException {
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

    public static void main (String[] args) throws FileNotFoundException, InterruptedException{
        MaxMultiThread m1 = new MaxMultiThread("moja1");
        m1.obliczaj(new Kwadratowa());

    }
}

