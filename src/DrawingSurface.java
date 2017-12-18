
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private Maze maze;
    public DrawingSurface() {
        maze = new Maze(0, 0, 400, 400, 10, 10);
    }

    public void draw() {
        background(255);
        maze.draw(this);
    }
}
