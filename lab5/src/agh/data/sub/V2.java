package agh.data.sub;

import agh.dat.Base;

public class V2 extends Base {
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
