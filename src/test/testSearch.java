package test;

import java.util.Iterator;

import graph.Arc;
import graph.DGraph;
import graph.IDirectedGraph;
import graph.IGraph;
import graph.IUndirectedGraph;
import graph.Node;
import graph.StringLabel;
import graph.UndirectedGraph;

public class testSearch {

	public static void main(String[] args) {
		//exemple wikipedia: graph oriente
		Node na = new Node(new StringLabel("A"));
		Node nb = new Node(new StringLabel("B"));
		Node nc = new Node(new StringLabel("C"));
		Node nd = new Node(new StringLabel("D"));
		Node ne = new Node(new StringLabel("E"));
		Node nf = new Node(new StringLabel("F"));
		Node ng = new Node(new StringLabel("G"));


		Arc aa = new Arc(na,nb, null);
		Arc ab = new Arc(nb,nd, null);
		Arc ac = new Arc(nb,nf, null);
		Arc ad = new Arc(na,nc, null);
		Arc ae = new Arc(nc,ng, null);
		Arc af = new Arc(na,ne, null);
		Arc ag = new Arc(ne,nf, null);
		
		IDirectedGraph dg = new DGraph();
		dg.addNode(na);dg.addNode(nb);dg.addNode(nc);dg.addNode(nd);dg.addNode(ne);dg.addNode(nf);dg.addNode(ng);
		dg.addArc(aa);dg.addArc(ab);dg.addArc(ac);dg.addArc(ad);dg.addArc(ae);dg.addArc(af);dg.addArc(ag);
		System.out.println(dg);

		Iterator<Node> iterdgBGS= dg.creerBFSIterator();
		System.out.println("Wiki bfs:");
		while (iterdgBGS.hasNext())
			System.out.println(iterdgBGS.next());
		
		Iterator<Node> iterdgDFS= dg.creerDFSIterator();
		System.out.println("Wiki dfs:");
		while (iterdgDFS.hasNext())
			System.out.println(iterdgDFS.next());
		
		//exemple graph non oriente
		System.out.println("Graph non oriente");
		
		IUndirectedGraph ug = new UndirectedGraph();
		ug.addNode(na);ug.addNode(nb);
		ug.addNode(nc);ug.addNode(nd);ug.addNode(ne);
		ug.addEdge(na, nb);
		ug.addEdge(na, nc);
		ug.addEdge(nc, nd);
		ug.addEdge(nc, ne);
				
		Iterator<Node> iterugBFS= ug.creerBFSIterator();
		System.out.println("bfs:");
		while (iterugBFS.hasNext())
			System.out.println(iterugBFS.next());
		
		Iterator<Node> iterugDFS= ug.creerDFSIterator();
		System.out.println("dfs:");
		while (iterugDFS.hasNext())
			System.out.println(iterugDFS.next());
	}
}
