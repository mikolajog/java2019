package agh.dat;

public class Another {
    private Base base;

    public void callBaseIncrement(){
        base.callIncrement();
    }

    public void callBaseDecrement(){
        base.callDecrement();
    }

    public void callBaseChangeName(String name){
        base.callChangeName(name);
    }
}
