package dataframe;

public  final class COOValue {
    private final int x;
    private final Object y;

    public int getX() {
        return x;
    }

    public Object getY() {
        return y;
    }

    COOValue(int x, Object y){
        this.x = x;
        this.y = y;
    }
}
