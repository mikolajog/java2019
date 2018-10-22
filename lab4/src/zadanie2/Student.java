package zadanie2;

public class Student extends Pracownik {

    Student(String pesel, double brutto){
        setPesel(pesel);
        setWynagrodzenieBrutto(brutto);
    }

    @Override
    double wynagrodzenieNetto() {
        return getWynagrodzenieBrutto()*0.9;
    }
}
