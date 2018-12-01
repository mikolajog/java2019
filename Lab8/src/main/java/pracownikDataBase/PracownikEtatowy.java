package pracownikDataBase;

public class PracownikEtatowy extends Pracownik {

    PracownikEtatowy(String pesel, double brutto){
        setPesel(pesel);
        setWynagrodzenieBrutto(brutto);
    }

    @Override
    double wynagrodzenieNetto() {
        return getWynagrodzenieBrutto()*0.5;
    }
}
