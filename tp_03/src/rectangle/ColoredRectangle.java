package rectangle;

import java.awt.Point;
import java.awt.Color;

/**
 * ColoredRectangle
 */
public class ColoredRectangle extends Rectangle implements Comparable<ColoredRectangle> {

    protected Color color;

    public ColoredRectangle(Point tl, Point br, Color color) {
        super(tl, br);
        this.color = color;
    }

    @Override
    public int compareTo(ColoredRectangle o) {
        return this.perimetre() - o.perimetre();
    };

    @Override
    public String toString() {
        return "[" + this.topLeft + ", " + this.bottomRight + ", " + this.color + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Rectangle) || !super.equals(o)) {
            return false;
        }
        Rectangle r = (Rectangle) o;
        return this.color == r.color;
    }

}