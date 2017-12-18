import processing.core.PApplet;

public class Maze
{
    private Tile[][] tiles;
    private final float ORIGIN_X = (float) 0;
    private final float ORIGIN_Y = (float) 0;

    public Maze(float width, float height, int numRows, int numCols)
    {
        float tileWidth = width / numCols;
        float tileHeight = height / numRows;
        tiles = new Tile[numRows][numCols];
        fillTilesArray(tileWidth, tileHeight, numRows, numCols);
    }

    private void fillTilesArray(float tileWidth, float tileHeight, int numRows, int numCols)
    {
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++)
                tiles[i][j] = new Tile(ORIGIN_X + (i * tileWidth),
                        ORIGIN_Y + (j * tileHeight), tileWidth, tileHeight);

    }

    public void draw(PApplet marker)
    {
        marker.pushStyle();
        for (int i = 0; i < tiles.length; i++)
        {
            for (int j = 0; j < tiles[i].length; j++)
            {
                tiles[i][j].draw(marker);
                
                if (tiles[i][j].isPointInside(marker.mouseX, marker.mouseY) && marker.mousePressed)
                    tiles[i][j].setFillColor(0);
            }
        }
        marker.popStyle();
        
        
    }
}
