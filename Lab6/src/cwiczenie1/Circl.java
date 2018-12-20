package cwiczenie1;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Circl extends Shape{

    public Circl(){
        name = "circle";
    }
    @Override
    public void draw(AnchorPane anchorPane) {
        anchorPane.getChildren().add(new Circle(300, 150, 25));
    }
}