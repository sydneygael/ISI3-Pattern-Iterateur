
package graph;

import java.util.LinkedList;

/**
 *
 * @author p1310563
 */
public class BFSIterator extends GraphIterator<LinkedList<Node>>
{
    public BFSIterator(IGraph graph, Node startNode)
    {
        super(graph, startNode, new LinkedList<>());
    }

    @Override
    protected Node currentNode()
    {
    	//on retourne l'�lement de t�te qui va repr�senter l'�lement courant
        return elements.poll();
    }
}
