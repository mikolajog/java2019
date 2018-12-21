package thread;

import random.GenerateRandoms;

public class Threads {
    public static void main(String[] args) {
        GenerateRandoms g1 = new GenerateRandoms("moja1");
        Thread thread = new Thread(g1);

        MaxMultiThread m1 = new MaxMultiThread("moja1");
        Thread thread1 = new Thread(m1);

        thread.start();
        thread1.start();
    }
}
