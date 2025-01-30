package uk.ac.ebi.pwp.structures.quadtree.client;

/**
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
class QuadItem<T extends QuadTreeBox> extends Box  {
    private T value;

    public QuadItem(T item) {
        super(item.getMinX(), item.getMinY(), item.getMaxX(), item.getMaxY());
        this.value = item;
    }

    public T getValue() {
        return value;
    }
}
