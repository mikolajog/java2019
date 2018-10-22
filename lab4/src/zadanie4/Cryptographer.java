package zadanie4;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Cryptographer {
    public static void cryptfile(String nazwaPlikuDoZaszyfrowania, String nazwaPlikuDocelowego, Algorithm a)throws FileNotFoundException{
        Scanner odczyt = new Scanner(new File(nazwaPlikuDoZaszyfrowania));
        PrintWriter zapis = new PrintWriter(nazwaPlikuDocelowego);
        String sentence;
        while(odczyt.hasNext()) {
            sentence = odczyt.nextLine();
            String[] parts = sentence.split(" ");
            for(int i=0; i<parts.length; i++){
                zapis.print(a.crypt(parts[i])+" ");

            }
            zapis.println("");
        }
        zapis.close();

    }

    public static void decryptfile(String nazwaPlikuDoRozszyfrowania, String nazwaPlikuDocelowego, Algorithm a)throws FileNotFoundException{
        Scanner odczyt = new Scanner(new File(nazwaPlikuDoRozszyfrowania));
        PrintWriter zapis = new PrintWriter(nazwaPlikuDocelowego);
        String sentence;
        while(odczyt.hasNext()) {
            sentence = odczyt.nextLine();
            String[] parts = sentence.split(" ");
            for(int i=0; i<parts.length; i++){
                zapis.print(a.decrypt(parts[i])+" ");

            }
            zapis.println("");
        }
        zapis.close();
    }

    public static void main(String[] args)throws FileNotFoundException {

        Cryptographer.cryptfile("plik1.txt", "plik2.txt", new ROT11());
        Cryptographer.decryptfile("plik2.txt", "plik1.txt", new ROT11());
        Cryptographer.cryptfile("p1.txt", "p2.txt", new Polibiusz());
        Cryptographer.decryptfile("p2.txt", "p1.txt", new Polibiusz());
    }
}
