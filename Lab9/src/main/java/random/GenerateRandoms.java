package random;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class GenerateRandoms implements Runnable  {


    public void run(){
        try {
            for (int i = 0; i < 10000; i++) {
                FileOutputStream fileStream = new FileOutputStream(new File("/home/mikolaj/Desktop/" + nazwaPliku + ".txt"), true);
                OutputStreamWriter out= new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);

                System.out.println("Tworze");
                Random rand = new Random();
                int n = rand.nextInt(10000) + 1;

                out.write(String.valueOf(n)+"\n");
                out.close();

                Thread.sleep(5);
            }

        }
        catch (InterruptedException e){}
        catch (java.io.FileNotFoundException a){}
        catch (java.io.UnsupportedEncodingException t){}
        catch (IOException e1){}
    }

    private String nazwaPliku;

    public GenerateRandoms (String nazwa){
        nazwaPliku = nazwa;
    }

}

