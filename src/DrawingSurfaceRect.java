
import processing.core.PApplet;

public class DrawingSurfaceRect extends PApplet
{

    private Maze maze;
    private PlayerRect playerR;

    private boolean[] keys = new boolean[6];
    private final int LEFT = 2;
    private final int UP = 3;
    private final int RIGHT = 4;
    private final int DOWN = 5;


    /*
     * Set player's original tile to beginning tile Fix canMove() and stuff
     * 
     * 
     */

    public DrawingSurfaceRect()
    {
        maze = new Maze(500, 500, 10, 10);
        playerR = new PlayerRect((int) (maze.getX()), (int) (maze.getY()), 40, 40);
    }

    public void draw()
    {
        background(255);

        playerR.setWidth((maze.getWidth() / maze.getNumCols()) - 5);
        playerR.setHeight((maze.getHeight() / maze.getNumRows()) - 5);

        act();
        playerRBoundary();

        maze.draw(this);
        playerR.draw(this);

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

                if (element.isPointInside(mouseX, mouseY) && keys[0])
                    element.setBeginning(true);
                else if (element.isPointInside(mouseX, mouseY) && keys[1])
                    element.setEnd(true);

                else if (element.isPointInside(mouseX, mouseY) && mouseButton == LEFT)
                    element.setIsWall(true);
                else if (element.isPointInside(mouseX, mouseY) && mouseButton == RIGHT)
                    element.setIsWall(false);

            }
        }
    }

    public void keyPressed()
    {
        if (key == 'b')
            keys[0] = true;
        if (key == 'e')
            keys[1] = true;
        if (this.keyCode == 37)
            keys[LEFT] = true;
        if (this.keyCode == 38)
            keys[UP] = true;
        if (this.keyCode == 39)
            keys[RIGHT] = true;
        if (this.keyCode == 40)
            keys[DOWN] = true;
    }

    public void keyReleased()
    {
        if (key == 'b')
            keys[0] = false;
        if (key == 'e')
            keys[1] = false;
        if (this.keyCode == 37)
            keys[LEFT] = false;
        if (this.keyCode == 38)
            keys[UP] = false;
        if (this.keyCode == 39)
            keys[RIGHT] = false;
        if (this.keyCode == 40)
            keys[DOWN] = false;
    }

    
    public void act()
    {
        int speed = 5;
        
        if (keys[LEFT] && canMove()) 
            playerR.setX(playerR.getX() - speed);
        if (keys[UP] && canMove()) 
            playerR.setY(playerR.getY() - speed);
        if (keys[RIGHT] && canMove()) 
            playerR.setX(playerR.getX() + speed);
        if (keys[DOWN] && canMove())
            playerR.setY(playerR.getY() + speed);
       
            
    }

    public boolean canMove()
    {
        for (int i = 0; i < maze.getNumCols(); i++)
        {
            for (int j = 0; j < maze.getNumRows(); j++)
            {
                Tile element = maze.getTiles()[i][j];
                
                if (element.overlaps(playerR) && element.isWall())
                {
//                    if (playerR.getX() < element.getX() + element.getWidth())
//                    {
//                        playerR.setX((int) (element.getX()));
//                    }
//                    if (playerR.getX() + playerR.getR() > element.getX())
//                    {
//                        playerR.setX((int) element.getX() - playerR.getR());
//                    }
//                    if (playerR.getY() + playerR.getHeight() > element.getY())
//                    {
//                        playerR.setY((int) (element.getY() - playerR.getHeight()));
//                    }
//                    if (playerR.getY() > element.getY() + element.getHeight())
//                    {
//                        playerR.setY((int) (element.getY() + element.getHeight()));
//                    }
                    
                    return false;
                }

            }
        }
        
        return true;
    }

    public void playerRBoundary()
    {
        if (playerR.getX() < maze.getX())
        {
            playerR.setX((int) (maze.getX()));
        }
        if (playerR.getX() + playerR.getR() > maze.getX() + maze.getWidth())
        {
            playerR.setX((int) (maze.getX() + maze.getWidth() - playerR.getR()));
        }
        if (playerR.getY() < maze.getY())
        {
            playerR.setY((int) (maze.getY()));
        }
        if (playerR.getY() + playerR.getR() > maze.getY() + maze.getHeight())
        {
            playerR.setY((int) (maze.getY() + maze.getHeight() - playerR.getR()));
        }
    }

}
