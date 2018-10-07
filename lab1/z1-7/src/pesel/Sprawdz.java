package pesel;

public class Sprawdz {
    public static void main(String[] argv){
        Pesel p1 = new Pesel();
        p1.wczytaj();
        Pesel.check(p1.pesel);
        System.out.println(p1.pesel);
    }
}
