import processing.core.PApplet;
import shapes.*;

public class Tile extends Rectangle
{

    public Tile(float x, float y, float width, float height)
    {
        super(x, y, width, height);
    }

    public void draw(PApplet marker)
    {
        marker.pushStyle();
        super.draw(marker);
        marker.popStyle();
    }
}
