import processing.core.PApplet;

public class Maze
{
    private Tile[][] tiles;
    private final float ORIGIN_X = 50;
    private final float ORIGIN_Y = 50;
    private int numRows;
    private int numCols;

    public Maze(float width, float height, int numRows, int numCols)
    {
        this.setNumRows(numRows);
        this.setNumCols(numCols);
        float tileWidth = width / numCols;
        float tileHeight = height / numRows;
        tiles = new Tile[numRows][numCols];

        MazeGenerator generator = new MazeGenerator(numRows + 1, numCols + 1);
        generator.generate();

        fillTilesArray(tileWidth, tileHeight, numRows, numCols, generator.getMaz());

    }

    private void fillTilesArray(float tileWidth, float tileHeight, int numRows, int numCols)
    {
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++)
                tiles[i][j] = new Tile(ORIGIN_X + (i * tileWidth), ORIGIN_Y + (j * tileHeight), tileWidth, tileHeight);

    }

    private void fillTilesArray(float tileWidth, float tileHeight, int numRows, int numCols, char[][] map)
    {
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++)
            {
                tiles[i][j] = new Tile(ORIGIN_X + (i * tileWidth), ORIGIN_Y + (j * tileHeight), tileWidth, tileHeight);

                if (map[i + 1][j + 1] == '.')
                    tiles[i][j].setIsWall(false);
                else if (map[i + 1][j + 1] == 'S')
                    tiles[i][j].setBeginning(true);
                else if (map[i + 1][j + 1] == 'E')
                    tiles[i][j].setBeginning(true);
                
            }

    }

    public void draw(PApplet marker)
    {
        marker.pushStyle();
        for (int i = 0; i < tiles.length; i++)
        {
            for (int j = 0; j < tiles[i].length; j++)
            {
                Tile element = tiles[i][j];
                element.draw(marker);

            }
        }
        marker.popStyle();

    }

    public int getNumRows()
    {
        return numRows;
    }

    public void setNumRows(int numRows)
    {
        this.numRows = numRows;
    }

    public int getNumCols()
    {
        return numCols;
    }

    public void setNumCols(int numCols)
    {
        this.numCols = numCols;
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }

    public void setTiles(Tile[][] tiles)
    {
        this.tiles = tiles;
    }

}
