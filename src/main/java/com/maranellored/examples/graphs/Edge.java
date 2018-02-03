package com.maranellored.examples.graphs;

import javafx.util.Pair;
import lombok.Getter;

/**
 * 2018
 */
@Getter
public class Edge {

  private final Pair<Vertex, Vertex> vertices;
  private final Integer weight;

  public Edge(Pair<Vertex, Vertex> vertices) {
    this(vertices, 0);
  }

  public Edge(Pair<Vertex, Vertex> vertices, int weight) {
    this.vertices = vertices;
    this.weight = weight;
  }

}
