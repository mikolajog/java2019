package zadanie3;

import zadanie2.Pracownik;

import java.util.Comparator;

public class PensjaComparator implements Comparator<Pracownik> {
    @Override
    public int compare(Pracownik a, Pracownik b) {
        return Double.compare(a.getWynagrodzenieBrutto(), b.getWynagrodzenieBrutto());
    }
}
