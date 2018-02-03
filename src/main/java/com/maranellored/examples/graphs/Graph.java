package com.maranellored.examples.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javafx.util.Pair;

/**
 * 2018
 */
public class Graph {
  private final Set<Edge> edges;
  private final Set<Vertex> vertices;

  public Graph() {
    this.edges = new HashSet<>();
    this.vertices = new HashSet<>();
  }

  public void addEdges(Set<Edge> edges) {
    this.edges.addAll(edges);
  }

  public void addVertices(Set<Vertex> vertices) {
    this.vertices.addAll(vertices);
  }

  public void addEdge(Edge edge) {
    this.edges.add(edge);
  }

  public void addVertex(Vertex vertex) {
    this.vertices.add(vertex);
  }

  public void createGraphFromEdges(Set<Edge> edges) {
    // Set edges in the graph
    this.addEdges(edges);

    // Go through edges and populate all vertices
    Set<Vertex> v = new HashSet<>();
    for(Edge e: edges) {
      Pair<Vertex, Vertex> vertexVertexPair = e.getVertices();
      v.add(vertexVertexPair.getKey());
      v.add(vertexVertexPair.getValue());
    }

    vertices.addAll(v);
  }

  private void findConnectedComponents() {
    Set<Vertex> visitedVertices = new HashSet<>();
    for (Vertex v : vertices) {
      if (!visitedVertices.contains(v)) {
        // Visit this using DFS
        depthFirstSearch(v, visitedVertices);
        System.out.println();
      }
    }
  }

  private void depthFirstSearch(Vertex v, Set<Vertex> visitedVertices) {
    // Mark this vertex as visited.
    visitedVertices.add(v);
    // Print the vertex
    System.out.print(v.getName() + "-");

    for (Vertex neighbor : v.getNeighbors()) {
      if (!visitedVertices.contains(neighbor)) {
        depthFirstSearch(neighbor, visitedVertices);
      }
    }

  }

  public static void main(String[] args) {
    Graph g = new Graph();
    Set<Edge> edges = buildEdges();
    g.createGraphFromEdges(edges);

    g.findConnectedComponents();
  }

  private static Set<Edge> buildEdges() {
    Vertex v1 = new Vertex("A");
    Vertex v2 = new Vertex("B");
    Vertex v3 = new Vertex("C");
    Vertex v4 = new Vertex("D");

    // Set neighbors
    v1.setNeighbor(v2);
    v2.setNeighbor(v1);
    v3.setNeighbor(v4);
    v4.setNeighbor(v3);

    // Create edges
    Edge e1 = new Edge(new Pair<>(v1, v2));
    Edge e2 = new Edge(new Pair<>(v3, v4));

    Set<Edge> edges = new HashSet<>();
    edges.add(e1);
    edges.add(e2);

    return edges;
  }


}
