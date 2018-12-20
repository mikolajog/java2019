package przyklad1;

class NowyWatek1 implements Runnable
{
    public
    void
    run()
    { System.out.println("     Nowy watek : POCZATEK");
        try { for (int i = 5; i > 0; i--)
            { System.out.println("     Nowy watek: " + i);
                Thread.sleep(500);
            }
        }
        catch
        (InterruptedException e) {}
        System.out.println("     Nowy watek : KONIEC");
    }  }
public class
GlownyWatek1
{
    public static void main(String args[])
    {  System.out.println(" Glowny watek: POCZATEK"
    );
        System.out.println(" Glowny watek: Tworze Nowy watek"
        );
        NowyWatek1 nowyWatek1 = new NowyWatek1();
        Thread thread = new Thread(nowyWatek1);
        System.out.println(" Glowny watek: Uruchamiam Nowy watek"
        );
        thread.start();
        try
        { for(int i = 5; i > 0; i--)
        { System.out.println(" Glowny watek: " + i);
            Thread.sleep(1000);
        }
        }
        catch
        (InterruptedException e) {}
        System.out.println(" Glowny watek: KONIEC");
    }  }