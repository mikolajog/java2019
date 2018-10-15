package punkt;

public class PunktProgram {
    public static void main(String[] args) {
        Punkt2D p1 = new Punkt2D(5.0, 4.0);
        Punkt2D p2 = new Punkt2D(1.0, 7.0);

        System.out.print(p1.distance(p2));

        Punkt3D p31 = new Punkt3D(5.0, 4.0, 6.0);
        Punkt3D p32 = new Punkt3D(1.0, 7.0, 9.0);

        System.out.print(p31.distance(p32));
    }


}
