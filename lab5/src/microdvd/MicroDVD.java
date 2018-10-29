/**
 * Klasa umożliwiająca edytowanie napisów w formacie MicroDVD
 *
 * @author Mikołaj Ogarek
 */
package microdvd;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicroDVD{
    String in, out;
    int delay, fps;

    public MicroDVD(String in_, String out_, int delay, int fps){
        this.in = in_;
        this.out = out_;
        this.delay = delay;
        this.fps = fps;
    }

    /**
     *
     * @param in_ ścieżka do pliku wejściowego
     * @param out_ ścieżka do pliku wyjściowego
     * @param delay opóźnienie
     * @param fps liczba klatek
     * @throws FileNotFoundException wyjątek, gdy nie znaleziono pliku wejściowego o podanej ścieżce
     * @throws BeginGraterThanEnd wyjątek, gdy początek napisu jest wyświetlany później niż koniec
     * @throws NotSupportedLine wyjątek, gdy liczba w nawiasach na początku jest innym znakiem
     */

    public void delay(String in_, String out_, int delay, int fps)throws FileNotFoundException, BeginGraterThanEnd, NotSupportedLine{
        Scanner odczyt = new Scanner(new File(in_));
        PrintWriter zapis = new PrintWriter(out_);
        String sentence;

        int beg;
        int end;
        double zmiana;

        while(odczyt.hasNext()){
            sentence = odczyt.nextLine();
            Pattern p = Pattern.compile("\\{([0-9]*)\\}\\{([0-9]*)\\}(.*)");
            Matcher m = p.matcher(sentence);
            if(!m.find()){
                throw new NotSupportedLine(sentence);
            }
            m.matches();
            beg = Integer.parseInt(m.group(1));
            end = Integer.parseInt(m.group(2));

            if(beg>end){
                throw new BeginGraterThanEnd(m.group(0));
            }

            zmiana = fps*0.001*delay;

            beg+= (int)zmiana;
            end+= (int)zmiana;

            zapis.println("{"+ beg + "}{"+end+"}"+m.group(3));
        }
        zapis.close();
    }

    /**
     *
     * W funkcji main wyłapujemy wyjątki
     */

    public static void main(String[] args){
        try{
            MicroDVD m1 = new MicroDVD("gravity.txt","gravity1.txt", 1000, 1);
            m1.delay(m1.in, m1.out, m1.delay, m1.fps);
        }
        catch (BeginGraterThanEnd e1){e1.communicate();}
        catch (FileNotFoundException e2){System.out.println("File not found!");}
        catch (NotSupportedLine e3){e3.communicate();}
        catch (Exception e4){System.out.println("Nieznany typ wyjątku");}
    }

}

class BeginGraterThanEnd extends Exception{
    String text;
    public BeginGraterThanEnd(String line){
        text = "Line:\""+line+"\""+" returned exception "+this.getClass().getSimpleName();
    }
    public void communicate(){
        System.out.println(text);
    }
}

class NotSupportedLine extends Exception{
    String text;
    public NotSupportedLine(String line){
        text = "Line:\""+line+"\""+" returned exception "+this.getClass().getSimpleName();
    }
    public void communicate(){
        System.out.println(text);
    }
}
