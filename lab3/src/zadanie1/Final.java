package zadanie1;

import java.util.LinkedList;

public class Final {
    public void wydrukujFinal(final double var){
        //cannot assign value to var
        //nie można zmieniac zmiennej final
        System.out.println(var);
    }

    public void zmienFinal(final LinkedList<Double> list){
        list.add(2.6);
        list.add(5.6);
        list.remove(0);
        System.out.println("Moge zmieniac liste final "+ list.get(0));
        //nie można zrobić list = new LinkedList<>();
    }
    public static void main(String[] args){
        Final f1 = new Final();
        f1.wydrukujFinal(8.9);
        LinkedList<Double> l = new LinkedList<>();

        f1.zmienFinal(l);
    }
}
