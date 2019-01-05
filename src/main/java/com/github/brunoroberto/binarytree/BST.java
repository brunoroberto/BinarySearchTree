package com.github.brunoroberto.binarytree;

import java.util.List;

/**
 * Binary Search Tree is a tree that has at maximum two children. The left child
 * is less or equal than the parent and the right child is greater than the
 * parent.
 * 
 * @author brunoroberto
 *
 * @param <T>
 */
public interface BST<T extends Comparable<T>> {

	public BSTNode<T> search(T key);

	public void add(T key);

	public void remove(T key);

	public List<T> inOrder();

	public List<T> preOrder();

	public List<T> posOrder();

}
