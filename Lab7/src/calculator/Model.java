package calculator;

public class Model {
    public int calculate(int x, int y, String znak){
        switch(znak){
            case "+":
                return x+y;
            case "-":
                return x-y;
        }
        return 0;
    }
}
