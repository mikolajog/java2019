package zadanie1;

import java.util.LinkedList;

public class ShapeList{
    private LinkedList<Shape> list = new LinkedList<>();
    void add(Shape s){
        list.add(s);
    }
    void read(){
        for(Shape s: list){
            s.draw();
        }
    }

    public static void main(String[] args){
        ShapeList sl1 = new ShapeList();
        sl1.add(new Circle());
        sl1.add(new Triangle());
        sl1.add(new Rectangle());
        sl1.read();
    }
}
