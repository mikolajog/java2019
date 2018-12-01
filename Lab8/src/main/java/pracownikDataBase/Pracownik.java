package pracownikDataBase;

public abstract class Pracownik {
    private String pesel;
    private double wynagrodzenieBrutto;

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setWynagrodzenieBrutto(double wynagrodzenieBrutto) {
        this.wynagrodzenieBrutto = wynagrodzenieBrutto;
    }

    public double getWynagrodzenieBrutto() {
        return wynagrodzenieBrutto;
    }

    public String getPesel() {
        return pesel;
    }

    abstract double wynagrodzenieNetto();

    @Override
    public String toString(){
        return String.format("{pesel=%s, płaca brutto=%f}", pesel, wynagrodzenieBrutto);
    }

}
