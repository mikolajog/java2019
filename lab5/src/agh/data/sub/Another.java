package agh.data.sub;

import agh.dat.Base;

public class Another {
    private Base base;

    public void callIncrement(){
        base.callIncrement();
    }

    public void callDecrement(){
        base.callDecrement();
    }

    public void callChangeName(String name){
        base.callChangeName(name);
    }
}
