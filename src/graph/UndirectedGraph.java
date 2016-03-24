/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author p1310563
 */
public class UndirectedGraph implements IUndirectedGraph
{

	private List<Arc> arcs = new ArrayList<Arc>();
	private List<Node> nodes = new ArrayList<Node>(); 

	@Override
	public void addEdge(Node _node1, Node _node2)
	{
		for(Arc a : arcs)
		{
			boolean condition = a.getSource().getID() == _node1.getID() 
					&& a.getDestination().getID() == _node2.getID() ? true:false;

			if ( condition) {
				//noththing to do because there is an arc
			}
			else {
				// un arc non orienté est dans les deux sens
				addArc(new Arc(_node1, _node2, null));
				addArc(new Arc(_node2, _node1, null));
			}
		}
	}

	@Override
	public boolean hasEdge(Node _node1, Node _node2)
	{
		return getAdjNodes(_node1).stream().
				anyMatch(nod -> nod.getID() == _node2.getID());
	}

	/**
	 * 
	 * @return un BFSIterator pour le graphe courant
	 */
	@Override
	public Iterator<Node> creerBFSIterator() {
		return new BFSIterator(this, nodes.get(0));
	}

	/**
	 * 
	 * @return un DFSIterator pour le graphe courant
	 */
	@Override
	public Iterator<Node> creerDFSIterator() {
		return new DFSIterator(this, nodes.get(0));
	}

	public void addArc(Arc _edge)
	{
		arcs.add(_edge);
	}

	@Override
	public void addNode(Node _node) {
		nodes.add(_node);

	}

	@Override
	public Set<Node> getAllNodes() {
		Set<Node> allNodes = new HashSet<>();

		nodes.stream().forEach((n) -> { allNodes.add(n); });

		return allNodes;
	}

	@Override
	public int getNbNodes() {
		return nodes.size();
	}

	@Override
	public List<Node> getAdjNodes(Node _n) {

		List<Node> returnN = new ArrayList<>();

		arcs.stream().forEach((a) ->
		{
			if(a.getSource().getID() == _n.getID())
				returnN.add(a.getDestination());
		});

		return returnN;
	}

	@Override
	public Iterator<Node> iterator(Node startNode) {
		return new BFSIterator(this, startNode);
	}

	@Override
	public Iterator<Node> iterator() {
		return new BFSIterator(this, nodes.get(0));
	}
}
