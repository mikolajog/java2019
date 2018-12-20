package thread;

public class Kwadratowa extends IHaveFunction{
    @Override
    public double function(String liczba) {
        double a = Double.parseDouble(liczba);
        return a*a + a + 2 ;
    }
}
