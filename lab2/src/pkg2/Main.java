package pkg2;

import pkg1.B;
import pkg1.A;

public class Main {
    public static void main (String[] args)
    {
        A a = new A(10, "Debil");
        B b = new B();
        C c = new C();

        a.callChangeName();
        a.callDecrement();
        a.callIncrement();

        b.callChangeName();
        b.callDecrement();
        b.callIncrement();

        c.callChangeName();
        c.callDecrement();
        c.callIncrement();

        c.changeName();
        
    }
}
