package photos;
import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.IOException;


public class Photos {
    public static void main(String[] args)throws IndicoException, IOException  {
        // single example
        Indico indico = new Indico("cf322678bf2f8778f26cba98aac97adc");
        IndicoResult single = indico.imageRecognition.predict(
                "Desktop/foto/kot2.jpg"
        );
        Double result = single.getContentFiltering();
        System.out.println(result);
    }
}
