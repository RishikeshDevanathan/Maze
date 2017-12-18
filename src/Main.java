import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main
{
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;

    
    public static void main(String args[])
    {
        DrawingSurface drawing = new DrawingSurface();
        PApplet.runSketch(new String[] { "" }, drawing);
        PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
        JFrame window = (JFrame) canvas.getFrame();

        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setMinimumSize(new Dimension(100, 100));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setVisible(true);
    }
}
