package agh.dat;

public class Base {
    private int value;
    String name;

    public void callChangeName(String name){
        changeName(name);
    }
    public void callIncrement(){
        increment();
    }
    public void callDecrement(){
        decrement();
    }
    private void increment(){
        value++;
    }
    protected void decrement(){
        value--;
    }
    void changeName(String name){
        this.name = name;
    }

}
