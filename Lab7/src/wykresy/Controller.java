package wykresy;


import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {

    public TextField wspolczynnikiField;
    public TextField zakresOdField;
    public Button rysujButton;
    public Button wyczyscButton;
    public TextField czestotliwoscField;
    public TextField zakresDoField;
    public AnchorPane anchorPane;
    private boolean isChartPresent = false;

    public void rysuj(ActionEvent actionEvent) {
        if(!isChartPresent) {
            Model model = new Model(wspolczynnikiField.getText(), zakresOdField.getText(), zakresDoField.getText(), czestotliwoscField.getText());
            model.drawLineChart(anchorPane);
            isChartPresent = true;
        }
    }

    public void wyczysc(ActionEvent actionEvent) {
        anchorPane.getChildren().clear();
        isChartPresent= false;
    }

}
