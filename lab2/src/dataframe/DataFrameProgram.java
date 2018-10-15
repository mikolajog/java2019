package dataframe;

import java.util.ArrayList;

public class DataFrameProgram {
    public static void main(String[] args)
    {
        DataFrame df = new  DataFrame(new String[]{"kol1","kol2","kol3"}, new String[]{"int","double","MyCustomType"});
        String variable = "zmienna";
        df.add_line(new Object[]{1, 2.3, "cosik"});
        df.add_line(new Object[]{2, 3.3, "cosik1"});
        df.add_line(new Object[]{3, 4.3, "cosik2"});

        System.out.println("DataFrame size is: "+df.size());

    }
}
