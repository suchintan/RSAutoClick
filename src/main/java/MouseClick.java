import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by suchintan on 2014-10-16.
 */
public class MouseClick {

    public static void main(String[] args) throws Exception{
        Robot r = new Robot();
        int iterations = 240;

        int xrange[] = new int[]{937, 980};
        int yrange[] = new int[]{305, 318};

        int xout[] = new int[]{4, 1439};
        int yout[] = new int[]{27, 808};

        System.out.println(MouseInfo.getPointerInfo().getLocation());


        for(int c = 0; c < iterations; c++){
            System.out.println("Iteration: " + (c+1) + " ");
            int x = (int)(Math.random() * (xrange[1] - xrange[0]))+xrange[0];
            int y = (int)(Math.random() * (yrange[1] - yrange[0]))+yrange[0];

            moveMouse(r, x, y);

            r.mousePress(InputEvent.BUTTON1_MASK);
            Thread.sleep((int)(Math.random()*100) + 200);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            Thread.sleep((int)(Math.random()*100) + 500);
            r.mousePress(InputEvent.BUTTON1_MASK);
            Thread.sleep((int)(Math.random()*100) + 200);
            r.mouseRelease(InputEvent.BUTTON1_MASK);

            int xo = (int)(Math.random() * (xout[1] - xout[0]))+xout[0];
            int yo = (int)(Math.random() * (yout[1] - yout[0]))+yout[0];

            moveMouse(r, xo, yo);

            Thread.sleep((int)(Math.random()*9000)+43000);
        }
    }

    public static void moveMouse(Robot r, int x, int y) throws Exception{
        Point p = MouseInfo.getPointerInfo().getLocation();
        int n = Math.max(Math.abs(p.x-x), Math.abs(p.y-y));
        double dx = ((double)(x-p.x)) / n;
        double dy = ((double)(y-p.y)) / n;
//        System.out.println(n + " " + dx + " " + dy);
        for(int c = 0; c < n; c++){
//            System.out.println(MouseInfo.getPointerInfo().getLocation());
            r.mouseMove((int)(p.x + dx*c), (int)(p.y + dy*c));
            Thread.sleep(2);
        }
    }
}
