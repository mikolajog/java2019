package zadanie2;

import java.util.Collections;
import java.util.LinkedList;


import zadanie3.PensjaComparator;


public class Kadry {
    private LinkedList<Pracownik> listaPracownikow = new LinkedList<>();

    void dodaj(Pracownik p){
        listaPracownikow.add(p);
    }

    void usun(Pracownik p){
        listaPracownikow.remove(p);
    }

    Pracownik wyszukaj(String pesel){
        for(Pracownik x: listaPracownikow){
            if(x.getPesel().equals(pesel)){
                return x;
            }
        }
        return null;
    }

    void zmienBrutto(String pesel, double brutto){
        listaPracownikow.get(listaPracownikow.indexOf(wyszukaj(pesel))).setWynagrodzenieBrutto(brutto);
    }

    double pobierzBrutto(String pesel){
        return listaPracownikow.get(listaPracownikow.indexOf(wyszukaj(pesel))).getWynagrodzenieBrutto();
    }

    double pobierzNetto(String pesel){
        return listaPracownikow.get(listaPracownikow.indexOf(wyszukaj(pesel))).wynagrodzenieNetto();
    }

    @Override
    public String toString(){
        String ret = "";
        for(Object o: listaPracownikow){
            ret+=o.toString()+"\n";
        }
        return ret;
    }

    public static void main(String[] args){
        Kadry kadry = new Kadry();


        Student s1 = new Student("12345678910", 1000.00);
        PracownikEtatowy p1 = new PracownikEtatowy("01987654321", 1000.00);

        kadry.dodaj(p1);
        kadry.dodaj(s1);

        System.out.print("Płaca brutto studenta: ");
        System.out.println(kadry.pobierzBrutto("12345678910"));

        System.out.print("Płaca brutto Etatowca: ");
        System.out.println(kadry.pobierzBrutto("01987654321"));

        System.out.print("Płaca netto studenta: ");
        System.out.println(kadry.pobierzNetto("12345678910"));

        System.out.print("Płaca netto Etatowca: ");
        System.out.println(kadry.pobierzNetto("01987654321"));


        System.out.println("Zmieniamy płacę Studenta i Etatowca. Student ma 2000 brutto, a Etatowiec 5000.");
        kadry.zmienBrutto("12345678910", 2000);
        kadry.zmienBrutto("01987654321", 5000);

        System.out.print("Płaca brutto studenta: ");
        System.out.println(kadry.pobierzBrutto("12345678910"));

        System.out.print("Płaca brutto Etatowca: ");
        System.out.println(kadry.pobierzBrutto("01987654321"));

        System.out.print("Płaca netto studenta: ");
        System.out.println(kadry.pobierzNetto("12345678910"));

        System.out.print("Płaca netto Etatowca: ");
        System.out.println(kadry.pobierzNetto("01987654321"));

        Collections.sort(kadry.listaPracownikow, new PensjaComparator());

        System.out.println(kadry);

    }












}
