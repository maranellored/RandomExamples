package com.maranellored.examples.trees;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 2018
 */
@Data
@Accessors(fluent = true)
public class TreeNode<T> {
  private final T data;
  private TreeNode leftChild;
  private TreeNode rightChild;
}
