
package graph;

import java.util.Stack;

/**
 *
 * @author p1310563
 */
public class DFSIterator extends GraphIterator<Stack<Node>>
{
	//on traitre le parcours en profondeur comme une pile
	//toutes les neouds seront donc visités par ordre de pile
    public DFSIterator(IGraph graph, Node startNode)
    {
        super(graph, startNode, new Stack<>());
    }

	@Override
	protected Node currentNode() {
		// retourne la tête de tous les elements
		return elements.pop();
		
	}
}
