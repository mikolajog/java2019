package random;

import java.io.PrintWriter;
import java.util.Random;

public class GenerateRandoms implements Runnable  {

    public void run(){
        try {
            PrintWriter writer = new PrintWriter("/home/mikolaj/Desktop/" + nazwaPliku + ".txt", "UTF-8");
            for (int i = 0; i < 10000; i++) {
                System.out.println("Tworze");
                Random rand = new Random();
                int n = rand.nextInt(10000) + 1;
                writer.println(n);
                Thread.sleep(100);
            }
            writer.close();
        }
        catch (InterruptedException e){}
        catch (java.io.FileNotFoundException a){}
        catch (java.io.UnsupportedEncodingException t){}
    }

    private String nazwaPliku;

    public GenerateRandoms (String nazwa){
        nazwaPliku = nazwa;
    }

}

