package cwiczenie1;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.font.LayoutPath;

public class Circl extends Shape{

    public Circl(){
        name = "circle";
    }
    @Override
    public void draw(AnchorPane anchorPane) {
        anchorPane.getChildren().add(new Circle(300, 150, 25));
    }
}