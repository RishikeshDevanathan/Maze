import processing.core.PApplet;
import shapes.*;

public class Tile extends Rectangle {
    private boolean isWall = true;
    private boolean beginning = false;
    private boolean end = false;

    public Tile(float x, float y, float width, float height)
    {
        super(x, y, width, height);
    }

    public void draw(PApplet marker)
    {
        marker.pushStyle();

        if (beginning)
            this.setFillColor(175);
        else if (end)
            this.setFillColor(75);
        else if (isWall)
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

    public void setBeginning(boolean beginning)
    {
        this.beginning = beginning;
    }

    public void setEnd(boolean end)
    {
        this.end = end;
    }
}