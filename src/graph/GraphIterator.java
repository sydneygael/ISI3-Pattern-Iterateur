
package graph;

import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author p1310563
 * classe inpirée de :
 * http://www.javaworld.com/article/2461744/java-language/java-language-iterating-over-collections-in-java-8.html
 * AbstractCollection<Node> permet de faire abstarcion de la structure de base utilisée
 * BFS : File
 * DFS : Pile
 */

public abstract class GraphIterator<T extends AbstractCollection<Node>> implements Iterator<Node>
{
	private final IGraph graph;
	private final Set<Node> visitedNodes;
	//représente tous les noeuds
	protected final T elements;

	protected GraphIterator(IGraph graph, Node startNode, T elements)
	{
		this.graph = graph;
		//représente tous les noeuds déjà visistés
		this.visitedNodes = new HashSet<>();
		// représente n'importe quel element contenu dans les noeuds
		this.elements = elements;
		//on commence par ajouter le noeud courant
		elements.add(startNode);
	}

	//permet de vérifier si il y a des fils
	//peut importe le parcours
	@Override
	public boolean hasNext()
	{
		return !elements.isEmpty();
	}

	//renvoie le noeud courant
	protected abstract Node currentNode();

	@Override
	public Node next()
	{
		// on récupère le noeud à parcourir
		Node current = currentNode();
		//on ajouter le neoud courant 
		visitedNodes.add(current);

		//JAVA 8
		graph.getAdjNodes(current).stream()
		//filter ne fait que vérifier si la condition est vraie
		//on regarde tous les noeuds fils qu'on a pas  enconre visité 
		.filter(nod -> !visitedNodes.contains(nod))
		//pour tous les neouds fils qui vérifient le prédicat
		// on ajoute un noeud dans la liste des elements à traiter
		.forEach(
				nod -> { elements.add(nod);
				visitedNodes.add(nod); 
				});
		return current;
	}


}
