package com.maranellored.examples.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javafx.util.Pair;

/**
 * 2018
 */
public class Tree {

  /**
   * Builds a Tree of the form -
   *
   *            A
   *         /     \
   *        B       C
   *       / \     / \
   *      D   E   F   G
   *     /
   *    H
   *   /
   *  I
   *
   * @return the root of the tree i.e. A
   */
  private static TreeNode buildStringTree() {
    TreeNode<String> a = new TreeNode<>("A");
    TreeNode<String> b = new TreeNode<>("B");
    TreeNode<String> c = new TreeNode<>("C");
    TreeNode<String> d = new TreeNode<>("D");
    TreeNode<String> e = new TreeNode<>("E");
    TreeNode<String> f = new TreeNode<>("F");
    TreeNode<String> g = new TreeNode<>("G");
    TreeNode<String> h = new TreeNode<>("H");
    TreeNode<String> i = new TreeNode<>("I");

    a.leftChild(b);
    a.rightChild(c);
    b.leftChild(d);
    b.rightChild(e);
    c.leftChild(f);
    c.rightChild(g);
    d.leftChild(h);
    h.leftChild(i);

    return a;
  }

  /**
   * Builds an integer tree of the form -
   *                    6
   *                /       \
   *               4         8
   *              / \       / \
   *             3   5     7   9
   *            /               \
   *           2                 10
   *          /
   *         1
   *
   * @return the root of the tree i.e. 6
   */
  private static TreeNode buildIntegerTree() {
    TreeNode<Integer> t1 = new TreeNode<>(1);
    TreeNode<Integer> t2 = new TreeNode<>(2);
    TreeNode<Integer> t3 = new TreeNode<>(3);
    TreeNode<Integer> t4 = new TreeNode<>(4);
    TreeNode<Integer> t5 = new TreeNode<>(5);
    TreeNode<Integer> t6 = new TreeNode<>(6);
    TreeNode<Integer> t7 = new TreeNode<>(7);
    TreeNode<Integer> t8 = new TreeNode<>(8);
    TreeNode<Integer> t9 = new TreeNode<>(9);
    TreeNode<Integer> t10 = new TreeNode<>(10);

    t2.leftChild(t1);
    t3.leftChild(t2);
    t4.leftChild(t3);
    t4.rightChild(t5);
    t6.leftChild(t4);
    t8.leftChild(t7);
    t8.rightChild(t9);
    t9.rightChild(t10);
    t6.rightChild(t8);

    return t6;
  }


  public static void main(String[] args) {
    // Build a tree
    TreeNode stringRoot = buildStringTree();
    printLevelOrder(stringRoot);

//    TreeNode intRoot = buildIntegerTree();
//    printDepthInOrder(intRoot);
//    printDepthPreOrder(intRoot);
//    printDepthInOrderIterative(intRoot);
  }

  private static void printLevelOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
    queue.add(new Pair<>(root, 0));
    int previousLevel = 0;

    while(!queue.isEmpty()) {
      Pair<TreeNode, Integer> nodeIntegerPair = queue.poll();
      TreeNode node = nodeIntegerPair.getKey();
      int currentLevel = nodeIntegerPair.getValue();
      if (currentLevel != previousLevel) {
        System.out.print(",");
        previousLevel = currentLevel;
      }

      System.out.print(node.data());

      if (node.leftChild() != null) {
        queue.add(new Pair<>(node.leftChild(), currentLevel+1));
      }

      if (node.rightChild() != null) {
        queue.add(new Pair<>(node.rightChild(), currentLevel+1));
      }
    }
  }


  private static void printDepthInOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    printDepthInOrder(root.leftChild());
    System.out.print(root.data());
    printDepthInOrder(root.rightChild());
  }

  private static void printDepthPreOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    System.out.print(root.data());
    printDepthPreOrder(root.leftChild());
    printDepthPreOrder(root.rightChild());
  }

  private static void printDepthInOrderIterative(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();

    stack.push(root);

    while(!stack.empty()) {
      TreeNode node = stack.pop();
      if (node.rightChild() != null) {
        stack.push(node.rightChild());
      }

      if (node.leftChild() != null) {
        stack.push(node.leftChild());
      }

      System.out.println(node.data());
    }

  }

}
