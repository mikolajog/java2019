package calculator;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.awt.*;

public class Controller {
    public TextField num1Field;
    public TextField num2Field;
    public Button plusButton;
    public Button minusButton;
    public TextField ResultField;
    public Circle circle;


    private int num1;
    private int num2;
    private int result;
    private Model model = new Model();

    public void anyButtonClick(ActionEvent event){
        Button button = (Button) event.getSource();
        String s = button.getText();
        num1 = Integer.parseInt(num1Field.getText());
        num2 = Integer.parseInt(num2Field.getText());
        result = model.calculate(num1, num2, s);
        ResultField.setText(String.valueOf(result));






    }


}
