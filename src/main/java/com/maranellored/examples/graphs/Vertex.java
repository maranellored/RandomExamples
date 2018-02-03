package com.maranellored.examples.graphs;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

/**
 * 2018
 */
@Getter
public class Vertex {
  private final String name;
  private final Set<Vertex> neighbors;

  public Vertex(String name) {
    this.name = name;
    this.neighbors = new HashSet<>();
  }

  public void setNeighbor(Vertex vertex) {
    this.neighbors.add(vertex);
  }
}
