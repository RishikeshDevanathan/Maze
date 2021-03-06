
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

    private Maze maze;
    private PlayerCirc playerC;
    
    private boolean[] keys = new boolean[6];

    public DrawingSurface()
    {
        maze = new Maze(500, 500, 50, 50);
        playerC = new PlayerCirc();
    }

    public void draw()
    {
        background(255);
        
        act();
        playerBoundary();
        
        maze.draw(this);
        playerC.draw(this);
        
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
        {
            keys[0] = true;
        }
        if (key == 'e')
        {
            keys[1] = true;
        }
        if (this.keyCode == 37) {
			keys[2] = true;
		}
		if (this.keyCode == 38) {
			keys[3] = true;
		}
		if (this.keyCode == 39) {
			keys[4] = true;
		}
		if (this.keyCode == 40) {
			keys[5] = true;
		}
    }

    public void keyReleased()
    {
        if (key == 'b')
        {
            keys[0] = false;
        }
        if (key == 'e')
        {
            keys[1] = false;
        }
        if (this.keyCode == 37) {
			keys[2] = false;
		}
		if (this.keyCode == 38) {
			keys[3] = false;
		}
		if (this.keyCode == 39) {
			keys[4] = false;
		}
		if (this.keyCode == 40) {
			keys[5] = false;
		}
    }
    
    int speed = 4;
    public void act() {
    		if (keys[2]) {
    			playerC.setX(playerC.getX() - speed);
    		}
    		else if (keys[3]) {
    			playerC.setY(playerC.getY() - speed);
    		}
    		else if (keys[4]) {
    			playerC.setX(playerC.getX() + speed);
    		}
    		else if (keys[5]) {
    			playerC.setY(playerC.getY() + speed);
    		}
    }

//    public boolean canMove() {
//    	for (int i = 0; i < maze.getTiles().length; i++) {
//    		for (int j = 0; j < maze.getTiles()[i].length; j++) {
//    			Tile element = maze.getTiles()[i][j];
//    			if (element.overlaps(playerR) == true) {
//    				if (element.isWall() == false) {
//    					return true;
//    				}
//    			}
//    		}
//    	}
//    	return false;
//    }
    
    public void playerBoundary() {
		if (playerC.getX() - playerC.getR() < maze.getX()) {
			playerC.setX((int) (maze.getX() + playerC.getR()));
		}
		if (playerC.getX() + playerC.getR() > maze.getX() + maze.getWidth()) {
			playerC.setX((int) (maze.getX() + maze.getWidth() - playerC.getR()));
		}
		if (playerC.getY() - playerC.getR() < maze.getY()) {
			playerC.setY((int) (maze.getY() + playerC.getR()));
		}
		if (playerC.getY() + playerC.getR() > maze.getY() + maze.getHeight()) {
			playerC.setY((int) (maze.getY() + maze.getHeight() - playerC.getR()));
		}
	}

}
