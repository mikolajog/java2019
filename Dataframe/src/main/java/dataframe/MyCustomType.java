package dataframe;

public class MyCustomType {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a){
        this.a = a;
    }

    public void setB(int b){
        this.b = b;
    }

    MyCustomType(int a, int b){
        this.a = a;
        this.b = b;
    }
    MyCustomType(MyCustomType t1){
        this.a = t1.a;
        this.b =t1.b;
    }
}
