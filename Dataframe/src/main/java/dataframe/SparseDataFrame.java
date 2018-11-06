package dataframe;

import java.io.*;
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

    public SparseDataFrame (DataFrame dataFrame, String hide){
        columns_names = dataFrame.columns_names.clone();
        types = dataFrame.types.clone();
        hide_val = hide;
        line_numbers=0;

        for(int i=0; i<columns_names.length; i++)
        {
            list.add(new ArrayList<>());
        }

        Object[] objects = new Object[dataFrame.list.size()];
        for(int i=0; i<dataFrame.list.get(0).size(); i++){
            for(int j=0; j<dataFrame.list.size(); j++) {
                objects[j] = dataFrame.list.get(j).get(i);
            }
            add_line(objects);
        }


        /*columns_names = dataFrame.columns_names.clone();
        types = dataFrame.types.clone();
        hide_val = hide;
        line_numbers = 0;

        for(int i=0; i<dataFrame.list.size(); i++){

        }
        */
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
        SparseDataFrame d1 = new SparseDataFrame(columns_names, types, hide_val);
        Object[] addition = new Object[columns_names.length];

        for(int j=0; j<columns_names.length; j++)
        {
            COOValue c1 = (COOValue) list.get(j).get(i);
            addition[j] = c1.getY();
        }

        d1.add_line(addition);


        return d1;
    }

    public SparseDataFrame ilocSparse(int from, int to)
    {
        SparseDataFrame d1 = new SparseDataFrame(columns_names, types, hide_val);
        Object[] addition = new Object[columns_names.length];
        for(int k=from; k<=to; k++) {
            for (int j = 0; j < columns_names.length; j++)
            {
                COOValue c1 = (COOValue) list.get(j).get(k);
                addition[j] = c1.getY();
            }

            d1.add_line(addition);
        }
        return d1;
    }

    public DataFrame toDense(){
        DataFrame ret = new DataFrame();
        ret.columns_names = this.columns_names.clone();
        ret.types = this.types.clone();
        int c,d = 0;
        COOValue val;
        Object[] add, comp;
        boolean war = true;
        int a = 0;

        for(int i=0; i<ret.columns_names.length; i++)
        {
            ret.list.add(new ArrayList<>());
        }

        while(war){
            war = false;
            add = new Object[this.columns_names.length];
            comp = new Object[this.columns_names.length];
            for(int f=0; f<this.columns_names.length; f++){
                add[f]=0;
                comp[f]=0;
            }
            for(int i=0; i<this.columns_names.length; i++){
                for(int j=0; j<this.list.get(i).size(); j++){
                    val = (COOValue) this.list.get(i).get(j);
                    if(val.getX()==a){
                        add[i] = val.getY();
                        war=true;
                    }
                }
            }

            if(war)
                {
                ret.add_line(add);
            }
            a++;
        }


        return ret;
    }

    public SparseDataFrame(String fileName, String[] tab, boolean header)throws FileNotFoundException, IOException {
        // Open the file
        this.columns_names = tab.clone();
        this.types = tab.clone();
        hide_val = "0.0";

        for(int i=0; i<columns_names.length; i++)
        {
            list.add(new ArrayList<>());
        }

        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        if(header){br.readLine();}
        Object[] o;
//Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            o=new Object[this.columns_names.length];
            String[] taby = strLine.split(",");
            for(int j=0; j<tab.length; j++){
                o[j] = taby[j];
            }
            this.add_line(o);
            System.out.println();
        }

//Close the input stream
        br.close();

    }




    public static void main (String[] args) throws FileNotFoundException, IOException
    {
        SparseDataFrame frejm = new SparseDataFrame("sparse.csv", new String[]{"int", "int", "int"}, true);

        ArrayList<Object> vf = frejm.get("int");
        COOValue v10f = (COOValue)vf.get(0);
        System.out.println(v10f.getX() +" "+ v10f.getY());
        COOValue v20f = (COOValue)vf.get(1);
        System.out.println(v20f.getX() +" "+ v20f.getY());

        SparseDataFrame df = new SparseDataFrame(new String[]{"kol1", "kol2", "kol3"}, new String[]{"int", "int", "int"}, "0");

        df.add_line(new Object[]{0,2,7});
        df.add_line(new Object[]{9,2,0});
        df.add_line(new Object[]{4,5,8});

        DataFrame dat = new DataFrame(new String[]{"kol1","kol2","kol3"}, new String[]{"int","int","int"});
        dat.add_line(new Object[]{0, 2, 8});
        dat.add_line(new Object[]{3, 4, 0});
        dat.add_line(new Object[]{2, 5 ,9});

        SparseDataFrame f1 = new SparseDataFrame(dat, "0");
        df = f1;


        ArrayList<Object> v = df.get("kol1");
        COOValue v10 = (COOValue)v.get(0);
        System.out.println(v10.getX() +" "+ v10.getY());
        COOValue v20 = (COOValue)v.get(1);
        System.out.println(v20.getX() +" "+ v20.getY());

        ArrayList<Object> v1 = df.get("kol2");
        COOValue v11 = (COOValue)v1.get(0);
        System.out.println(v11.getX() +" "+ v11.getY());
        COOValue v22 = (COOValue)v1.get(1);
        System.out.println(v22.getX() +" "+ v22.getY());


        ArrayList<Object> v2 = df.get("kol3");
        COOValue v111= (COOValue)v2.get(0);
        System.out.println(v111.getX() +" "+ v111.getY());
        COOValue v222 = (COOValue)v2.get(1);
        System.out.println(v222.getX() +" "+ v222.getY());


        SparseDataFrame d1 = df.get_Sparse(new String[]{"kol1"}, false);

        ArrayList<Object> v110 = d1.get("kol1");
        COOValue v1110 = (COOValue)v110.get(0);
        System.out.println(v1110.getX() +" "+ v1110.getY());
        COOValue v2110 = (COOValue)v110.get(1);
        System.out.println(v2110.getX() +" "+ v2110.getY());


        SparseDataFrame d2 = df.ilocSparse(0,1);
        ArrayList<Object> a = d2.get("kol3");
        COOValue a1 = (COOValue)a.get(0);
        System.out.println(a1.getX() + " "+ a1.getY());
        COOValue a2 = (COOValue)a.get(1);
        System.out.println(a2.getX() +" "+ a2.getY());


        SparseDataFrame d3 = df.ilocSparse(0);
        ArrayList<Object> b = d3.get("kol2");
        COOValue b1 = (COOValue)b.get(0);
        System.out.println(b1.getX() +" "+ b1.getY());

        DataFrame dejta = df.toDense();

        System.out.println("Sprawdzam get(kol1)");
        ArrayList<Object> dej = dejta.get("kol1");
        System.out.println(dej.get(0)+" "+ dej.get(1)+ " "+dej.get(2));
        System.out.println("Sprawdzam get(kol2)");
        ArrayList<Object> dej1 = dejta.get("kol2");
        System.out.println(dej1.get(0)+" "+ dej1.get(1)+ " "+dej1.get(2));
        System.out.println("Sprawdzam get(kol3)");
        ArrayList<Object> dej2 = dejta.get("kol3");
        System.out.println(dej2.get(0)+" "+ dej2.get(1)+ " "+dej2.get(2));

    }
}
