import processing.core.PApplet;
import shapes.*;

public class Tile extends Rectangle
{
    private boolean isWall = false;
    
    public Tile(float x, float y, float width, float height)
    {
        super(x, y, width, height);
    }

    public void draw(PApplet marker)
    {
        marker.pushStyle();
        
        if (isWall)
            this.setFillColor(0);
        else
            this.setFillColor(255);
        
        super.draw(marker);
        marker.popStyle();
    }

    public boolean isWall()
    {
        return isWall;
    }

    public void setIsWall(boolean isWall)
    {
        this.isWall = isWall;
    }
}
