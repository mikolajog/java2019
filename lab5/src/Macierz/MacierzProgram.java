package Macierz;

import java.io.FileNotFoundException;

public class MacierzProgram {
    public static void main(String[] args) throws MatrixDimensionsException, FileNotFoundException
    {
try {
    Macierz m1 = new Macierz("macierz.txt");
    Macierz m2 = new Macierz(3, 2);

    m1.wyswietl();

    m2.wypelnij();
    m2.wyswietl();

    m1.mult(m2).wyswietl();
}
catch(MatrixDimensionsException e1){e1.communicate();}
finally {

}
    }
}
