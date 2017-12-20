
import processing.core.PApplet;

public class DrawingSurfaceRect extends PApplet {

    private Maze maze;
    private PlayerRect playerR;
    
    private boolean[] keys = new boolean[6];
    
    /*	Set player's original tile to beginning tile
     * 	Fix canMove() and stuff
     * 
     * 
     */
    
    public DrawingSurfaceRect()
    {
        maze = new Maze(500, 500, 10, 10);
        playerR = new PlayerRect((int) (maze.getX()), (int) (maze.getY()), 50, 50);
    }

    public void draw()
    {
        background(255);
        
        playerR.setWidth(maze.getWidth() / maze.getNumCols());
        playerR.setHeight(maze.getHeight() / maze.getNumRows());
        
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
    
    int speed = 5;
    public void act() {
    		if (keys[2] && canMove()) {
    			playerR.setX(playerR.getX() - speed);
    		}
    		else if (keys[3] && canMove()) {
    			playerR.setY(playerR.getY() - speed);
    		}
    		else if (keys[4] && canMove()) {
    			playerR.setX(playerR.getX() + speed);
    		}
    		else if (keys[5] && canMove()) {
    			playerR.setY(playerR.getY() + speed);
    		}
    }

    public boolean canMove() {
    	for (int i = 0; i < maze.getTiles().length; i++) {
    		for (int j = 0; j < maze.getTiles()[i].length; j++) {
    			Tile element = maze.getTiles()[i][j];
    			if (element.overlaps(playerR) == true) {
    				if (element.isWall() == false) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
    
    public void playerRBoundary() {
		if (playerR.getX() < maze.getX()) {
			playerR.setX((int) (maze.getX()));
		}
		if (playerR.getX() + playerR.getR() > maze.getX() + maze.getWidth()) {
			playerR.setX((int) (maze.getX() + maze.getWidth() - playerR.getR()));
		}
		if (playerR.getY() < maze.getY()) {
			playerR.setY((int) (maze.getY()));
		}
		if (playerR.getY() + playerR.getR() > maze.getY() + maze.getHeight()) {
			playerR.setY((int) (maze.getY() + maze.getHeight() - playerR.getR()));
		}
	}

}
