
import processing.core.PApplet;

public class DrawingSurface extends PApplet
{
    private Maze maze;

    public DrawingSurface()
    {
        maze = new Maze(500, 500, 20, 20);
    }

    public void draw()
    {
        background(255);
        maze.draw(this);
    }
}
