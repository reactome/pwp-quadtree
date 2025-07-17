package uk.ac.ebi.pwp.structures.quadtree;


import junit.framework.TestCase;
import uk.ac.ebi.pwp.structures.quadtree.client.Box;
import uk.ac.ebi.pwp.structures.quadtree.client.QuadTree;

import java.util.Set;

/**
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
public class QuadTree2DTest extends TestCase {

    private QuadTree<Box> tree;

    public QuadTree2DTest() {
        this.tree = new QuadTree<>(15000, 15000);
    }

    public void testElement(){
        Box node = new Box(10, 10, 20, 20);
        this.tree.add(node);
        Set<Box> set = tree.getItems(15, 15);
        assert (set.contains(node));
    }

    public void testElements(){
        for (int i = 0; i < 1000; i++) {
            testElement();
        }
    }
}
