
import processing.core.PApplet;

public class DrawingSurface extends PApplet
{
    private Maze maze;

    public DrawingSurface()
    {
        maze = new Maze((float) 500, (float) 500, 20, 20);
    }

    public void draw()
    {
        background(255);
        maze.draw(this);
    }
}
