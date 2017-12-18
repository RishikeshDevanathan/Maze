
import processing.core.PApplet;

public class DrawingSurface extends PApplet
{
    private Maze maze;

    public DrawingSurface()
    {
        maze = new Maze(500, 500, 10, 10);
    }

    public void draw()
    {
        background(255);
        maze.draw(this);
        
        if (mousePressed)
            check();
    }
    
    
    public void check()
    {
        for (int i = 0; i < maze.getNumRows(); i++)
        {
            for (int j = 0; j < maze.getNumCols(); j++)
            {
                Tile element = maze.getTiles()[i][j];
                
                if (element.isPointInside(mouseX, mouseY) && mouseButton == LEFT)
                    element.setIsWall(true);
                else if (element.isPointInside(mouseX, mouseY) && mouseButton == RIGHT)
                    element.setIsWall(false);

                
            }
        }

    }
}
