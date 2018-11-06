package appl;

import excp.DivideByZero;
import excp.FactorialFromNegative;
import excp.TooBigNumberException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Calculator implements Saveable {
    @Override
    public void SaveToFile(double x, String filename) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(filename);
        zapis.print(result);
    }

    private double result;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Calculator(){
        result = 0.0;
    }

    public void add(double x){
        result+=x;
    }

    public void subtract(double x){
        result-=x;
    }

    public void multiply(double x){
        result = result*x;
    }

    public void divide(double x) throws DivideByZero{
        if(x==0.0){
            throw new DivideByZero();
        }
        result = result/x;
    }

    public void factorial(double x) throws TooBigNumberException, FactorialFromNegative{

        if(x>10){
            throw new TooBigNumberException();
        }
        if(x<0){
            throw  new FactorialFromNegative();
        }
        int a=1;
        for(int i=1; i<=x; i++){
            a=a*i;
        }
        result = a;
    }

    public static void main(String[] args) throws TooBigNumberException, FactorialFromNegative, DivideByZero{

        Calculator c = new Calculator();
        try {
            c.add(1.2);
            System.out.println(c.getResult());

            c.subtract(1.1);
            System.out.println(c.getResult());

            c.multiply(4);
            System.out.println(c.getResult());

            c.divide(5);
            System.out.println(c.getResult());

            c.factorial(3);
            System.out.println(c.getResult());
        }
        catch(TooBigNumberException e1){System.out.println("Zbyt duża");}
        catch(FactorialFromNegative e2){System.out.println("Silnia z mniejszej od zera");}
        catch(DivideByZero e3){System.out.println("Nie dzielimy przez zero!");}

    }
}
