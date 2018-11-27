package osoby;


import zadanie1.SimpleFrame;

import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

public class FrameTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleFrame frame = new SimpleFrame();
                frame.addComponentListener(new ComponentListener() {

                    @Override
                    public void componentShown(ComponentEvent e) {
                        System.out.println(Thread.currentThread().getStackTrace()[1]);
                    }

                    @Override
                    public void componentResized(ComponentEvent e) {
                        System.out.println(Thread.currentThread().getStackTrace()[1]);
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {
                        System.out.println(Thread.currentThread().getStackTrace()[1]);
                    }

                    @Override
                    public void componentHidden(ComponentEvent e) {
                        System.out.println(Thread.currentThread().getStackTrace()[1]);
                    }
                });
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
