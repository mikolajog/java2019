package dataframe;

import java.util.ArrayList;
import java.util.Arrays;


public class DataFrame {

    protected String[] columns_names;
    protected String[] types;
    protected ArrayList<ArrayList<Object>> list = new ArrayList<>();

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

    public DataFrame(){}

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
        DataFrame d1 = new DataFrame();
        d1.types = new String[cols.length];
        d1.columns_names = new String[cols.length];
        d1.columns_names = cols.clone();
        int i=0;
        for(String x:cols){
            if(copy)
            {
                d1.types[i] = types[Arrays.asList(columns_names).indexOf(x)];

                if(list.get(Arrays.asList(columns_names).indexOf(x)).get(0).getClass().getSimpleName().equals("MyCustomType"))
                {
                    d1.list.add(new ArrayList<>());

                    for(int j=0; j<list.get(Arrays.asList(columns_names).indexOf(x)).size(); j++){
                        MyCustomType t1 = new MyCustomType((MyCustomType)(list.get(Arrays.asList(columns_names).indexOf(x)).get(j)));
                        d1.list.get(d1.list.size()-1).add(t1);
                    }
                }
                else{
                    d1.list.add(new ArrayList<>(list.get(Arrays.asList(columns_names).indexOf(x))));
                }
            }
            else{
                d1.types[i] = types[Arrays.asList(columns_names).indexOf(x)];
                d1.list.add(new ArrayList<>(list.get(Arrays.asList(columns_names).indexOf(x))));
            }
            i++;
        }

        return d1;


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
        //deklarujemy DataFrame
        DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"}, new String[]{"int","double","MyCustomType"});
        MyCustomType variable = new MyCustomType(1,2);
        df.add_line(new Object[]{1, 2.3, variable});
        df.add_line(new Object[]{2, 3.3, variable});
        df.add_line(new Object[]{3, 4.3, variable});

        //rozmiar
       System.out.println("DataFrame size is: "+df.size());

       //iloc(0) powinien stworzyc nowa DataFrame z wierszem pierwszym z poprzedniej
       System.out.println("Sprawdzam iloc(0)");
       DataFrame d2 = df.iloc(0);
       MyCustomType type = (MyCustomType) d2.list.get(2).get(0);
       System.out.println(d2.list.get(0).get(0)+" "+d2.list.get(1).get(0)+" " + type.getA() + " " + type.getB());

        //iloc(0,1) powinien stworzyc nowa DataFrame z wierszem pierwszym i drugim z poprzedniej
        System.out.println("Sprawdzam iloc(0,1)");
        DataFrame d3 = df.iloc(0,1);
        MyCustomType type1 = (MyCustomType) d3.list.get(2).get(0);
        MyCustomType type2 = (MyCustomType) d3.list.get(2).get(1);
        System.out.println(d3.list.get(0).get(0)+" "+d3.list.get(1).get(0)+" "+type1.getA() + " " + type1.getB());
        System.out.println(d3.list.get(0).get(1)+" "+d3.list.get(1).get(1)+" "+type2.getA() + " " + type2.getB());

        //get("kol1") zwraca ArrayList<Object> z kolumną pierwszą
        System.out.println("Sprawdzam get(kol1)");
        ArrayList<Object> a1 = df.get("kol1");
        System.out.println(a1.get(0)+" "+ a1.get(1)+ " "+a1.get(2));

        //get("kol1") zwraca ArrayList<Object> z kolumną trzecią, zatem z obiektami MyCustomType
        System.out.println("Sprawdzam get(kol3)");
        ArrayList<Object> a2 = df.get("kol3");
        MyCustomType c1 = (MyCustomType) a2.get(0);
        MyCustomType c2 = (MyCustomType) a2.get(1);
        MyCustomType c3 = (MyCustomType) a2.get(2);
        System.out.println(c1.getA() +" "+c1.getB() +" "+c2.getA() +" "+c2.getB() +" "+c3.getA() +" "+c3.getB() +" ");

        //get(new String[]{"kol2", "kol3"}, true) w zależności od drugiego argumentu albo tworzy głęboką albo płytką kopie
        //rzeczywiscie potem jak zmieniamy wartosci dla obiektu m to jesli jest to kopia plytka to sie zmienia
        //jesli gleboka to sie nie zmienia

        DataFrame d4 = df.get(new String[]{"kol2", "kol3"}, true);
        System.out.println(d4.list.get(0).get(0)+" "+d4.list.get(1).get(0));

        ArrayList<Object> x = df.get("kol3");
        MyCustomType m = (MyCustomType) x.get(0);
        System.out.println(m.getA() +" "+ m.getB());

        ArrayList<Object> x1 = d4.get("kol3");
        MyCustomType m1 = (MyCustomType) x1.get(0);
        System.out.println(m1.getA() + " "+ m1.getB());

        m.setA(100);
        m.setB(200);

        System.out.print(m.getA()+" ");
        System.out.println(m.getB());
        System.out.print(m1.getA()+" ");
        System.out.println(m1.getB());


    }
}
