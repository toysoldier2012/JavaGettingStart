package datastructure;

import java.util.*;

public class Graph {
	Map<Integer, GraphNode> graphNodes = new HashMap<>();
	int[][] nodesMatrix;

	public Graph(Map<Integer, GraphNode> graphNodes){
		this.graphNodes = graphNodes;
		nodesMatrix = new int[graphNodes.size()][graphNodes.size()];
	}

	public void addNode(int index, GraphNode graphNode){
		graphNodes.put(index, graphNode);
		int[][] tempMatrix = new int[graphNodes.size()][graphNodes.size()];
		for(int i = 0; i < nodesMatrix.length; i++){
			System.arraycopy(nodesMatrix[i], 0, tempMatrix[i], 0, nodesMatrix.length);
		}
	}

	public void addEdge(GraphNode graphNodeA, GraphNode graphNodeB){

	}
}

class GraphNode {
	private String name;

	public GraphNode(String name){
		this.name = name;
	}
}

