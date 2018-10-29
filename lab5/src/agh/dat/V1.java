package agh.dat;

public class V1 extends Base{

    private void increment(){
        callIncrement();
    }

    protected void decrement(){
        callDecrement();
    }

    void changeName(String name){
        callChangeName(name);
    }
}
