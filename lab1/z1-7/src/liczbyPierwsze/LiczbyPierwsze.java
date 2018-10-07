package liczbyPierwsze;

import javaIn.JIn;

import static java.lang.StrictMath.sqrt;

public class LiczbyPierwsze {
    int liczba;
    public void wczytaj (){
        System.out.print("Podaj liczbe: ");
        liczba = JIn.getNumber();
    }
    public void znajdzLiczbyPierwsze(){
        Boolean[] wartosci = new Boolean[liczba+1];

        for(int i=0; i<liczba+1; i++)
        {
            wartosci[i]=true;
        }

        for(int i=2; i<=sqrt(liczba); i++)
        {
            if(wartosci[i] == true)
            {
                for(int j = i*i; j<=liczba; j=j+i)
                {
                    wartosci[j] = false;
                }
            }
        }

        for (int i=2; i<liczba+1; i++)
        {
            if(wartosci[i]==true){
                System.out.println(i);
            }
        }

    }



}
