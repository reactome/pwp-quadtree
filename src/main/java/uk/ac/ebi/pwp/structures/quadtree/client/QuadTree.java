package uk.ac.ebi.pwp.structures.quadtree.client;

import java.util.Set;

/**
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
public class QuadTree<T extends QuadTreeBox> {

    private QuadNode<T> root = null;

    public QuadTree(double minX, double minY, double maxX, double maxY){
        root = new QuadNode<>(minX, minY, maxX, maxY, 5, 25);
    }

    public QuadTree(double minX, double minY, double maxX, double maxY, int numberOfItems, int minArea){
        root = new QuadNode<>(minX, minY, maxX, maxY, numberOfItems, minArea);
    }

    public QuadTree(double width, double height) {
        this(0, 0, width, height);
    }

    public QuadTree(double width, double height, int numberOfItems, int minArea) {
        this(0, 0, width, height, numberOfItems, minArea);
    }

    public boolean add(T item){
        return root.add(new QuadItem<>(item));
    }

    public void clear() {
        root.clear();
    }
    public boolean remove(T item){
        return root.remove(item);
    }

    public Set<T> getItems(){
        return root.getItems();
    }

    public Set<T> getItems(double x, double y){
        return root.getItems(x,y);
    }

    public Set<T> getItems(QuadTreeBox area){
        return root.getItems(area);
    }

}
