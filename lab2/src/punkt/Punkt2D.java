package punkt;

public class Punkt2D {
    /*Napisz klasę Punkt2D, zawierająca dwa pola typu double określające współrzędne x, y. Klasa powinna mieć jedynie konstruktor parametrowy przyjmujący wartości x, oraz y. Klasa nie może mieć konstruktora bezparametrowego.

    Metody klasy do zaimplementowania:
        getX, getY, setX, setY;
        distance - pobierająca jako parametr obiekt typu Punkt2D i zwracająca odległość od tego punktu w układzie współrzędnych (wartość double)
*/
    private double x;
    private double y;

    public Punkt2D(double _x, double _y){
        x=_x;
        y=_y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double _x){
        x = _x;
    }
    public void setY(double _y){
        y = _y;
    }

    public double distance(Punkt2D p1)
    {
        return Math.sqrt((x-p1.x)*(x-p1.x) +(y-p1.y)*(y-p1.y));
    }




}
