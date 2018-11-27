package cwiczenie1;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Triangl extends Shape{
    public Triangl(){
        name = "Triangle";
    }
    @Override
    public void draw(AnchorPane anchorPane)
    {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{
                300.00, 120.00,
                200.00, 200.00,
                400.00, 200.0 });

        anchorPane.getChildren().add(polygon);
    }
}