import java.awt.Color;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import shapes.Rectangle;

public class PlayerRect extends Rectangle {
	
	public PlayerRect(int x, int y, int width, int height) {
		super(x, y, width, height);
		super.setFillColor(125);
	}

	public int getR() {
		return (int) super.getWidth();
	}
	
	
	public void draw(PApplet drawer) {
		super.draw(drawer);
	}
}

