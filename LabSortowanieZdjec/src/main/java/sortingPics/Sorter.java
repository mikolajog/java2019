package sortingPics;

import io.indico.Indico;
import io.indico.api;
import io.indico.api.BatchIndicoResult;
import io.indico.api.results.IndicoResult;

import java.util.List;

public class Sorter {
    public static void main (String[] args) throws io.indico.api.utils.IndicoException{
        // single example
        Indico indico = new Indico("YOUR_API_KEY");
        IndicoResult single = indico.imageRecognition.predict(
                "<IMAGE>"
        );
        Double result = single.getImageRecognition();
        System.out.println(result);

// batch example
        String[] example = {
                "<IMAGE>",
                "<IMAGE>"
        };
        BatchIndicoResult multiple = indico.imageRecognition.predict(example);
        List<Double> results = multiple.getImageRecognition();
        System.out.println(results);
    }
}



