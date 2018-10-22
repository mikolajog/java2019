package zadanie1;

public abstract class Shape{
    public String name;
    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw();
}

class Circle extends Shape{

    public Circle(){
        name = "circle";
    }
    @Override
    public void draw() {
        System.out.println(name);
    }
}

class Triangle extends Shape{
    public Triangle(){
        name = "Triangle";
    }
    @Override
    public void draw() {
        System.out.println(name);
    }
}

class Rectangle extends Shape{

    public Rectangle(){
        name = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println(name);
    }
}

class Main{
    public static void main(String[] args){
        Circle c = new Circle();
        Triangle t = new Triangle();
        Rectangle r = new Rectangle();

        c.draw();
        t.draw();
        r.draw();;
    }
}
