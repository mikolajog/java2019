package dataframe;

import java.util.ArrayList;
import java.util.Arrays;

public class SparseDataFrame extends DataFrame {

    protected String hide_val;
    protected int line_numbers;

    public SparseDataFrame(String[] col_names, String[] type, String hide){
        columns_names = col_names.clone();
        types = type.clone();
        hide_val = hide;
        line_numbers = 0;

        for(int i=0; i<columns_names.length; i++)
        {
            list.add(new ArrayList<>());

        }
    }

    public SparseDataFrame(){}

    public int size(){
        return line_numbers;
    }

    public void add_line(Object[] object)
    {
        for(int i=0; i<object.length; i++)
        {
            if(object[i].toString().equals(hide_val)){
                continue;
            }
            else
            {
                this.list.get(i).add(new COOValue(line_numbers, object[i]));
            }

        }
        line_numbers++;
    }

    public SparseDataFrame get_Sparse(String[] cols, boolean copy)
    {
        SparseDataFrame d1 = new SparseDataFrame();
        d1.types = new String[cols.length];
        d1.columns_names = new String[cols.length];
        d1.columns_names = cols.clone();
        int i=0;
        for(String x:cols){
            if(copy)
            {
                d1.types[i] = types[Arrays.asList(columns_names).indexOf(x)];


                    d1.list.add(new ArrayList<>());

                    for(int j=0; j<list.get(Arrays.asList(columns_names).indexOf(x)).size(); j++){
                        COOValue v1 = (COOValue)list.get(Arrays.asList(columns_names).indexOf(x)).get(j);
                        COOValue t1 = new COOValue(v1.getX(), v1.getY());
                        d1.list.get(d1.list.size()-1).add(t1);
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

    public SparseDataFrame ilocSparse(int i)
    {
        SparseDataFrame d1 = new SparseDataFrame(columns_names, types, hide_val.toString());
        Object[] addition = new Object[columns_names.length];

        for(int j=0; j<columns_names.length; j++)
        {
            addition[j] = list.get(j).get(i);
        }

        d1.add_line(addition);

        return d1;
    }

    public SparseDataFrame ilocSparse(int from, int to)
    {
        SparseDataFrame d1 = new SparseDataFrame(columns_names, types, hide_val.toString());
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


    public static void main (String[] args){
        SparseDataFrame df = new SparseDataFrame(new String[]{"kol1", "kol2", "kol3"}, new String[]{"int", "int", "int"}, "0");

        df.add_line(new Object[]{1,2,0});
        df.add_line(new Object[]{0,2,1});
        df.add_line(new Object[]{4,5,8});

        ArrayList<Object> v = df.get("kol1");
        COOValue v1 = (COOValue)v.get(0);
        System.out.println(v1.getX() +" "+ v1.getY());
        COOValue v2 = (COOValue)v.get(1);
        System.out.println(v2.getX() +" "+ v2.getY());

        SparseDataFrame d1 = df.get_Sparse(new String[]{"kol1"}, false);
        ArrayList<Object> v11 = d1.get("kol1");
        COOValue v111 = (COOValue)v11.get(0);
        System.out.println(v111.getX() +" "+ v111.getY());
        COOValue v211 = (COOValue)v11.get(1);
        System.out.println(v211.getX() +" "+ v211.getY());

        SparseDataFrame d2 = df.ilocSparse(0,1);
        ArrayList<Object> a = d2.get("kol1");
        COOValue a1 = (COOValue)a.get(0);
        System.out.println(a1.getX() +" "+ a1.getY());
        COOValue a2 = (COOValue)a.get(1);
        System.out.println(a2.getX() +" "+ a2.getY());

        SparseDataFrame d3 = df.ilocSparse(0);
        ArrayList<Object> b = d3.get("kol3");
        COOValue b1 = (COOValue)b.get(0);
        System.out.println(b1.getX() +" "+ b1.getY());

    }
}
