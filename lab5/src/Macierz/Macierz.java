
package Macierz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Macierz{
    private ArrayList<ArrayList<Integer>> tab = new ArrayList<>();
    private int x;
    private int y;


    public Macierz(int x, int y)
    {
        this.x = x;
        this.y = y;
        for(int i=0; i<x; i++){
            tab.add(new ArrayList<Integer>());
            for(int j=0; j<y; j++){
                tab.get(i).add(0);
            }
        }
    }

    public Macierz(String in_) throws FileNotFoundException
    {
        Scanner odczyt = new Scanner(new File(in_));
        String sentence;
        int i=0;
        while(odczyt.hasNext())
        {
            sentence = odczyt.nextLine();
            String[] parts = sentence.split(" ");
            this.y = parts.length;
            this.x = i;
            i++;
        }

        for(i=0; i<this.x; i++){
            tab.add(new ArrayList<Integer>());
            for(int j=0; j<this.y; j++){
                tab.get(i).add(0);
            }
        }

        i=0;
        int liczba;
        while(odczyt.hasNext())
        {
            sentence = odczyt.nextLine();
            String[] parts = sentence.split(" ");
            for(int j=0; j<parts.length; j++)
            {
                liczba = Integer.parseInt(parts[j]);
                tab.get(i).set(j, liczba);
            }

        }

    }

    public void wypelnij(){
        int liczba;
        Scanner odczyt = new Scanner(System.in);
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                liczba = odczyt.nextInt();
                tab.get(i).set(j, liczba);
            }
        }
    }
    public void wyswietl(){
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                System.out.print(tab.get(i).get(j)+" ");
            }
            System.out.println(" ");
        }
    }

    public Macierz dod(Macierz m) throws MatrixDimensionsException
    {
        if(this.x!=m.x || this.y!=m.y)
        {
            throw new MatrixDimensionsException();
        }
        Macierz result = new Macierz(x,y);
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                result.tab.get(i).set(j,tab.get(i).get(j)+ m.tab.get(i).get(j));
            }
        }
        return result;
    }

    public Macierz odej(Macierz m) throws MatrixDimensionsException
    {
        if(this.x!=m.x || this.y!=m.y)
        {
            throw new MatrixDimensionsException();
        }
        Macierz result = new Macierz(x,y);
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                result.tab.get(i).set(j,tab.get(i).get(j)-m.tab.get(i).get(j));
            }
        }
        return result;
    }

    public Macierz mult(Macierz m) throws MatrixDimensionsException
    {
        int addition;
        if(this.y!=m.x)
        {
            throw new MatrixDimensionsException();
        }
        Macierz result = new Macierz(this.x,m.y);
        for(int i=0; i<result.x; i++)
        {
            for(int j=0; j<result.y; j++)
            {
                addition=0;
                for(int k=0; k<y; k++)
                {
                    addition+=(tab.get(i).get(k)*m.tab.get(k).get(j));
                }
                result.tab.get(i).set(j, addition);
            }
        }
        return result;
    }


}

class MatrixDimensionsException extends Exception{
    public void communicate(){
        System.out.println(getClass().getSimpleName()+ " -unable to perform action.");
    }
}
