
import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;

public class PlayerCirc {

	PShape player;
	private int x, y, radius;

	
	public PlayerCirc() {
		this.x = 215;
		this.y = 215;
		this.radius = 4;
	}


	public void setup(PApplet drawer) {
		
		player = drawer.createShape(PConstants.ELLIPSE, x, y, radius*2, radius*2);
		player.setFill(drawer.color(Color.red.getRGB()));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getR() {
		return radius;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void draw(PApplet drawer) {
		setup(drawer);
		drawer.shape(player);
	}
}
