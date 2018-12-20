package cwiczenie1;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {
    public TextField textField;
    public Button clearButton;
    public AnchorPane paneId;
    public Button showButton;
    private String shapeName;
    private boolean isShapePresent=false;
    public void clearShape(ActionEvent actionEvent) {
        if(isShapePresent){
            paneId.getChildren().remove(paneId.getChildren().size()-1);
        }
        isShapePresent=false;
    }
    public void showShape(ActionEvent actionEvent) {
        shapeName = textField.getText();
        if(!isShapePresent){
            switch (shapeName) {
                case "Circle":
                    Circl c = new Circl();
                    c.draw(paneId);
                    isShapePresent = true;
                    break;
                case "Triangle":
                    Triangl t = new Triangl();
                    t.draw(paneId);
                    isShapePresent = true;
                    break;
                case "Rectangle":
                    Rectangl r = new Rectangl();
                    r.draw(paneId);
                    isShapePresent = true;
                    break;
            }
        }
    }
}
