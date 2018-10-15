package pkg1;

/*Zaimplementuj następującą relację pomiędzy klasami i przetestuj metody call* dla wszystkich 3 obiektów.
 Metody w klasie B powinny różnić się do tych z klasy A (np. metoda increment() z klasy A
 zwiększa zmienną number o 1, natomiast ta sama metoda w klasie B o 2) [1.0]:
 */
public class A {
    int number;
    protected String name;

    public A(int number, String name){
        this.number = number;
        this.name = name;
    }
    public void callDecrement(){
        decrement();
    }
    public void callChangeName(){
        changeName();
    }
    public void callIncrement(){
        increment();
    }
    private void increment(){
        number++;
    }
    protected void decrement(){
        number--;
    }
    void changeName(){
        name = "AName";
    }
}