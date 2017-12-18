import processing.core.PApplet;

public class Tile {
	private float originX;
	private float originY;
	private int rowIndex;
	private int colIndex;
	private float width;
	private float height;
	private float x;
	private float y;
	
    public Tile(float originX, float originY, int rowIndex, int colIndex, float tileWidth, float tileHeight) {
        this.originX = originX;
        this.originY = originY;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.width = tileWidth;
        this.height = tileHeight;
        this.x = originX + tileWidth*colIndex;
        this.y = originY + tileHeight*rowIndex;
    }
    
    public void draw(PApplet marker) {
    	marker.pushStyle();
    	marker.color((int) (Math.random()*255.0));
    	marker.rect(x, y, width, height);
    	marker.popStyle();
    }
}
