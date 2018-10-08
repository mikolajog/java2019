package Macierz;
import java.util.Scanner;

public class Macierz{
    private int[][] tab;
    private int x;
    private int y;


    public Macierz(int x, int y)
    {
        this.x = x;
        this.y = y;
        tab = new int[x][y];
    }

    public void wypelnij(){
        int liczba;
        Scanner odczyt = new Scanner(System.in);
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                liczba = odczyt.nextInt();
                tab[i][j] = liczba;
            }
        }
    }
    public void wyswietl(){
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                System.out.print(tab[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    public Macierz dod(Macierz m)
    {
        Macierz result = new Macierz(x,y);
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                result.tab[i][j] = tab[i][j]+ m.tab[i][j];
            }
        }
        return result;
    }

    public Macierz odej(Macierz m)
    {
        Macierz result = new Macierz(x,y);
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                result.tab[i][j] = tab[i][j]- m.tab[i][j];
            }
        }
        return result;
    }

    public Macierz mult(Macierz m)
    {
        Macierz result = new Macierz(x,y);
        for(int i=0; i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                result.tab[i][j] = 0;
                for(int k=0; k<x; k++)
                {
                    result.tab[i][j] += this.tab[i][k]*m.tab[k][j];
                }
            }
        }
        return result;
    }

}
