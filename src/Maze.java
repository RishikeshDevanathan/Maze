import processing.core.PApplet;

public class Maze
{
    private Tile[][] tiles;
    private float x;
    private float y;
    
    public Maze(float x, float y, float width, float height, int numRows, int numCols) {
        this.x = x;
        this.y = y;
    	float tileWidth = width/numCols;
        float tileHeight = height/numRows;
        tiles = new Tile[numRows][numCols];
        fillTilesArray(tileWidth, tileHeight, numRows, numCols);
    }

	private void fillTilesArray(float tileWidth, float tileHeight, int numRows, int numCols) {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				Tile tile = new Tile(x, y, i, j, tileWidth, tileHeight);
				tiles[i][j] = tile;
			}
		}
	}
	
	public void draw(PApplet marker) {
		marker.pushStyle();
    	for(int i = 0; i < tiles.length; i++) {
    		for (int j = 0; j < tiles[i].length; j++) {
    			tiles[i][j].draw(marker);
    		}
    	}
    	marker.popStyle();
	}
}
