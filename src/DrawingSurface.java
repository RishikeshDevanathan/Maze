
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	private Maze maze;
	private boolean[] keys = new boolean[2];

	public DrawingSurface() {
		maze = new Maze(500, 500, 12, 12);
	}

	public void draw() {
		background(255);
		maze.draw(this);

		if (mousePressed)
			check();
	}

	public void check() {
		for (int i = 0; i < maze.getNumRows(); i++) {
			for (int j = 0; j < maze.getNumCols(); j++) {
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

	public void keyPressed() {
		if (key == 'b') {
			keys[0] = true;
		}
		if (key == 'e') {
			keys[1] = true;
		}
	}

	public void keyReleased() {
		if (key == 'b') {
			keys[0] = false;
		}
		if (key == 'e') {
			keys[1] = false;
		}
	}
}
