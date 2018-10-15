package dataframe;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/*

Zaimplementuj klasę DataFrame, która pozwalać będzie na przechowywanie dowolnej ilości danych, dowolnego typu w formacie kolumnowym (analogicznie jak w bazie danych).
 Konstruktor tej klasy powinien przyjmować jako parametry listę stringów, określającą nazwy kolumn, oraz listę typów określającą typy poszczególnych kolumn:

DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"},
                         new String[]{"int","double","MyCustomType"}

Wymagania dodatkowe:

    Kolumny powinny być przechowywane jako ArrayList

    Klasa powinna posiadać metody:
        size() – zwracającą ilość wierszy w całej DF (uwaga – DF nie może mieć jednej z kolumn dłuższej niż pozostałe
        get(String colname) – zwracającą kolumnę o podanej nazwie
        get(String [] cols, boolean copy) – zwracającą nową DataFrame z kolumnami podanymi jako parametry. W zależności od wartości parametru copy albo tworzona jest głęboka kopia, albo płytka.
        iloc(int i) – zwracającą wiersz o podanym indeksie (jako nową DataFrame)
        iloc(int from, int to) – zwracającą nową DataFrame z wierszami z podanego zakresu

*/



public class DataFrame {

    private String[] columns_names;
    private String[] types;
    private ArrayList<ArrayList<Object>> list = new ArrayList<>();

    /*DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"},
                         new String[]{"int","double","MyCustomType"} */

    public DataFrame(String[]columns_names, String[] types)
    {
        this.columns_names= columns_names.clone();
        this.types = types.clone();

        for(int i=0; i<columns_names.length; i++)
        {
            list.add(new ArrayList<>());
        }
    }

    public int size(){
        return list.get(0).size();
    }

    public void add_line(Object[] object)
    {
        for(int i=0; i<object.length; i++)
        {
            list.get(i).add(object[i]);
        }
    }

    public ArrayList<Object> get(String colname)
    {
        for(int i=0; i<columns_names.length; i++)
        {
            if(columns_names[i].equals(colname))
            {
                return list.get(i);
            }
        }
        return null;
    }

    public DataFrame get(String[] cols, boolean copy)
    {
        if(copy)
        {

        }
        else
        {
            String[] empty = new String[]{};
            DataFrame d1 = new DataFrame(empty, empty);
            for(int i=0; i<cols.length; i++)
            {
                ArrayList<Object> a1 = new ArrayList<>();
                if(cols[i].equals(types[i]))
                {
                    for(int j=0; j<list.get(i).size(); j++)
                    {
                        a1.add(list.get(i).get(j));
                    }
                    d1.list.add(a1);
                }
            }
        }
    }

    public DataFrame iloc(int i)
    {
        DataFrame d1 = new DataFrame(columns_names, types);
        Object[] addition = new Object[columns_names.length];

        for(int j=0; j<columns_names.length; j++)
        {
            addition[j] = list.get(j).get(i);
        }

        d1.add_line(addition);

        return d1;
    }

    public DataFrame iloc(int from, int to)
    {
        DataFrame d1 = new DataFrame(columns_names, types);
        Object[] addition = new Object[columns_names.length];
        for(int k=from; k<=to; k++) {
            for (int j = 0; j < columns_names.length; j++)
            {
                addition[j] = list.get(j).get(k);
            }

            d1.add_line(addition);
        }
            return d1;

    }


    public static void main(String[] args)
    {
        DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"}, new String[]{"int","double","MyCustomType"});
        String variable = "zmienna";
        df.add_line(new Object[]{1, 2.3, "cos"});
        df.add_line(new Object[]{2, 3.3, "cos1"});
        df.add_line(new Object[]{3, 4.3, "cos2"});

        System.out.println("DataFrame size is: "+df.size());
        DataFrame d2 = df.iloc(0);
        System.out.println(d2.list.get(0).get(0)+" "+d2.list.get(1).get(0)+" "+d2.list.get(2).get(0));

        DataFrame d3 = df.iloc(1,2);
        System.out.println(d3.list.get(0).get(0)+" "+d3.list.get(1).get(0)+" "+d3.list.get(2).get(0));
        System.out.println(d3.list.get(0).get(1)+" "+d3.list.get(1).get(1)+" "+d3.list.get(2).get(1));

        ArrayList<Object> a1 = df.get("kol1");
        System.out.println(a1.get(0)+" "+ a1.get(1)+ " "+a1.get(2));

    }
}
