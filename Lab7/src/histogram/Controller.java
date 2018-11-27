package histogram;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public Button showID;
    public TextField zakresOdId;
    public TextField zakresDoId;
    public TextField aId;
    public TextField bId;
    public TextField cId;
    public TextField dId;
    public Button rysujButton;
    public Button wyczyscButton;
    public TextField krokId;
    public Label krolLabel;
    public LineChart lineChart;
    private boolean isPresentChart = false;
    private int aField =0;
    private int bField =0;
    private int cField =0;
    private int dField =0;
    private int odField=0;
    private int doField=0;



    public void drawing(ActionEvent actionEvent) {
        if(!isPresentChart)
        {
            aField = Integer.parseInt(aId.getText());
            bField = Integer.parseInt(bId.getText());
            cField = Integer.parseInt(cId.getText());
            dField = Integer.parseInt(dId.getText());
            odField = Integer.parseInt(zakresOdId.getText());
            doField = Integer.parseInt(zakresDoId.getText());

            XYChart.Series series = new XYChart.Series();
            series.setName("My portfolio");
            series.getData().
            series.getData().add(new XYChart.Data(1, 23));
            series.getData().add(new XYChart.Data(2, 14));
            series.getData().add(new XYChart.Data(3, 15));
            series.getData().add(new XYChart.Data(4, 24));
            series.getData().add(new XYChart.Data(5, 34));
            series.getData().add(new XYChart.Data(6, 36));
            series.getData().add(new XYChart.Data(7, 22));
            series.getData().add(new XYChart.Data(8, 45));
            series.getData().add(new XYChart.Data(9, 43));
            series.getData().add(new XYChart.Data(10, 17));
            series.getData().add(new XYChart.Data(11, 29));
            series.getData().add(new XYChart.Data(12, 25));

            lineChart.getData().add(series);
        }
    }

    public void clearing(ActionEvent actionEvent) {
        if(isPresentChart){}
    }
}

