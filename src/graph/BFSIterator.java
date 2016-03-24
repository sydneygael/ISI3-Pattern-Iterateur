
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
    	//on retourne l'élement de tête qui va représenter l'élement courant
        return elements.poll();
    }
}
