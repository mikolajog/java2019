package punkt;

import java.util.LinkedList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        LinkedList<Punkt3D> punkty = new LinkedList<>();
        LinkedList<String> nazwy = new LinkedList<>();

        boolean stan = true;
        while (stan) {
            System.out.print("Wybierz:\n1. Wczytaj punkt 3D\n" +
                    "2. Wyświetl wszystkie punkty\n" +
                    "3. Oblicz odległość\n" +
                    "4. Zakończ\n" +
                    "?: ");
            int liczba;
            Scanner odczyt = new Scanner(System.in);
            liczba = odczyt.nextInt();

            switch (liczba) {
                case 1:
                    System.out.println("Podaj 3 liczby double: ");
                    double x, y, z;
                    x = odczyt.nextDouble();
                    y = odczyt.nextDouble();
                    z = odczyt.nextDouble();
                    Punkt3D p1 = new Punkt3D(x, y, z);
                    System.out.print("Podaj nazwe punktu: ");
                    odczyt.nextLine();
                    String nazwa;
                    nazwa = odczyt.nextLine();
                    nazwy.add(nazwa);
                    punkty.add(p1);
                    break;
                case 2:
                    for(int i=0; i<punkty.size(); i++)
                    {
                        System.out.println(nazwy.get(i)+" "+ punkty.get(i).getX()+ " "+punkty.get(i).getY()+ " "+ punkty.get(i).getZ()+ " ");
                    }
                    break;
                case 3:
                    System.out.print("Podaj nazwe punktu 1: ");
                    odczyt.nextLine();
                    String nazwa1;
                    nazwa1 = odczyt.nextLine();

                    System.out.print("Podaj nazwe punktu 2: ");

                    String nazwa2;
                    nazwa2= odczyt.nextLine();

                    Punkt3D p11 = new Punkt3D(0,0,0);
                    Punkt3D p22 = new Punkt3D(0,0,0);

                    System.out.println("Podano:"+nazwa1+" "+nazwa2);

                    for(int i=0; i<punkty.size(); i++)
                    {
                        if(nazwy.get(i).equals(nazwa1))
                        {
                            p11 = punkty.get(i);
                        }
                        if(nazwy.get(i).equals(nazwa2))
                        {
                            p22 = punkty.get(i);
                        }
                    }
                    System.out.println("Odległość wynosi:"+ p11.distance(p22));
                    break;
                case 4:
                    stan = false;
                    break;
            }
        }

    }
}
