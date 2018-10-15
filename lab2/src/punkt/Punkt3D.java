package punkt;

public class Punkt3D extends Punkt2D {
    private double z;

    public Punkt3D(double _x, double _y, double _z)
    {
        super(_x, _y);
        this.setX(_x);
        this.setY(_y);
        this.setZ(_z);
    }

    public double getZ(){
        return z;
    }
    public void setZ(double _z){
        z = _z;
    }



    public double distance(Punkt3D p1)
    {
        return Math.pow(((getX()-p1.getX())*(getX()-p1.getX()) +(getY()-p1.getY())*(getY()-p1.getY()) + (z-p1.z)*(z-p1.z)), 1.0/3.0);
    }

}
