package Macierz;

public class MacierzProgram {
    public static void main(String[] args)
    {

        Macierz m1 = new Macierz(2,2);
        Macierz m2 = new Macierz(2,2);

        m1.wypelnij();
        m1.wyswietl();

        m2.wypelnij();
        m2.wyswietl();

        m1.dod(m2).wyswietl();
        m2.odej(m1).wyswietl();

        m1.mult(m2).wyswietl();

    }
}
