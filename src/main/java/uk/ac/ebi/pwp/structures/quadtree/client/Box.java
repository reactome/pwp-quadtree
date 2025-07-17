package uk.ac.ebi.pwp.structures.quadtree.client;

/**
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
public class Box implements QuadTreeBox {
    private double minX;
    private double minY;
    private double maxX;
    private double maxY;
    private double centreX;
    private double centreY;

    public Box(double minX, double minY, double maxX, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.centreX = (maxX - minX) / 2 + minX;
        this.centreY = (maxY - minY) / 2 + minY;
    }

    public boolean contains(double x, double y) {
        return (this.minX <= x &&
                this.maxX >= x &&
                this.minY <= y &&
                this.maxY >= y);
    }

    public boolean contains(QuadTreeBox quadTreeBox) {
        return (this.minX <= quadTreeBox.getMinX() &&
                this.maxX >= quadTreeBox.getMaxX() &&
                this.minY <= quadTreeBox.getMinY() &&
                this.maxY >= quadTreeBox.getMaxY());
    }

    public boolean intersects(QuadTreeBox quadTreeBox) {
        return !(quadTreeBox.getMinX() > this.maxX ||
                quadTreeBox.getMaxX() < this.minX ||
                quadTreeBox.getMinY() > this.maxY ||
                quadTreeBox.getMaxY() < this.minY);
    }

    public boolean isValidArea(double minArea) {
        double width = maxX - minX;
        double height = maxY - minY;
        return width > 1.0 && height > 1.0 && Math.abs(width * height) >= minArea;
    }

    public double getArea() {
        return (maxX - minX) * (maxY - minY);
    }

    public double getCentreX() {
        return centreX;
    }

    public double getCentreY() {
        return centreY;
    }

    @Override
    public double getMinX() {
        return minX;
    }

    @Override
    public double getMinY() {
        return minY;
    }

    @Override
    public double getMaxX() {
        return maxX;
    }

    @Override
    public double getMaxY() {
        return maxY;
    }

    public boolean touches(QuadTreeBox quadTreeBox) {
        return this.contains(quadTreeBox) || this.intersects(quadTreeBox);
    }
}
