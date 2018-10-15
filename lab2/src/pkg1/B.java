package pkg1;

public class B extends A {
    protected void decrement(){
        number = number-3;
    }
    void changeName(){
        name = "BName";
    }
    private void increment(){
        number = number+3;
    }
    public B(){
        super(0,"");
    }
}
