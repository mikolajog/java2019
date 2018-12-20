package cwiczenie1;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Rectangl extends Shape{

    public Rectangl(){
        name = "Rectangle";
    }

    @Override
    public void draw(AnchorPane anchorPane) {
        Rectangle r = new Rectangle();
        r.setX(200);
        r.setY(100);
        r.setWidth(200);
        r.setHeight(100);
        anchorPane.getChildren().add(r);
    }
}