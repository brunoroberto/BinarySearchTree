package com.github.brunoroberto.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> implements BST<T> {

	private BSTNode<T> root;

	@Override
	public BSTNode<T> search(T key) {
		return searchNode(key);
	}

	private BSTNode<T> searchNode(T key) {
		BSTNode<T> it = root;
		while (it != null) {
			if (isEqual(key, it.getKey()))
				return it;
			if (isGreaterThan(key, it.getKey()))
				it = it.getRight();
			else
				it = it.getLeft();
		}
		return null;
	}

	@Override
	public void add(T key) {
		BSTNode<T> newNode = new BSTNode<T>(key, null);
		if (root == null) {
			this.root = newNode;
			return;
		}

		BSTNode<T> it = root;
		while (it != null) {
			if (isGreaterThan(key, it.getKey())) {
				if (it.getRight() == null) {
					addRightChild(it, newNode);
					break;
				}
				it = it.getRight();
			} else {
				if (it.getLeft() == null) {
					addLeftChild(it, newNode);
					break;
				}
				it = it.getLeft();
			}
		}
	}

	@Override
	public void remove(T key) {
		// removeNode(key, this.root);
		deleteNode(key);
	}

	private void deleteNode(T key) {
		BSTNode<T> node = searchNode(key);

		// could not find the key
		if (node == null)
			return;

		// first case: the node is a leaf
		if (node.isLeaf()) {
			if (node.equals(this.root))
				this.root = null;
			else if (isLeftChild(node))
				node.getParent().setLeft(null);
			else
				node.getParent().setRight(null);
			node.setParent(null);
		} else if (node.getLeft() == null) { // second case: the node has only one child -> right
			if (node.equals(this.root))
				this.root = node.getRight();
			else if (isLeftChild(node))
				node.getParent().setLeft(node.getRight());
			else
				node.getParent().setRight(node.getRight());
			node.getRight().setParent(node.getParent());
		} else if (node.getRight() == null) { // second case: the node has only one child -> left
			if (node.equals(this.root))
				this.root = node.getLeft();
			else if (isLeftChild(node))
				node.getParent().setLeft(node.getLeft());
			else
				node.getParent().setRight(node.getLeft());
			node.getLeft().setParent(node.getParent());
		} else { // third case: the node has two child
			BSTNode<T> temp = findMin(node);
			node.setKey(temp.getKey());

			if (isLeftChild(temp))
				temp.getParent().setLeft(null);
			else
				temp.getParent().setRight(null);
			temp.setParent(null);
		}
	}

	private BSTNode<T> findMin(BSTNode<T> node) {
		BSTNode<T> it = node;
		while (it.getLeft() != null)
			it = it.getLeft();
		return it;
	}

	@Override
	public List<T> inOrder() {
		List<T> values = new ArrayList<>();
		inOrder(this.root, values);
		return values;
	}

	private void inOrder(BSTNode<T> node, List<T> values) {
		if (node == null)
			return;
		inOrder(node.getLeft(), values);
		values.add(node.getKey());
		inOrder(node.getRight(), values);
	}

	@Override
	public List<T> preOrder() {
		List<T> values = new ArrayList<>();
		preOrder(this.root, values);
		return values;
	}

	private void preOrder(BSTNode<T> node, List<T> values) {
		if (node == null)
			return;
		values.add(node.getKey());
		preOrder(node.getLeft(), values);
		preOrder(node.getRight(), values);
	}

	@Override
	public List<T> posOrder() {
		List<T> values = new ArrayList<>();
		posOrder(this.root, values);
		return values;
	}

	private void posOrder(BSTNode<T> node, List<T> values) {
		if (node == null)
			return;
		preOrder(node.getLeft(), values);
		preOrder(node.getRight(), values);
		values.add(node.getKey());
	}

	private boolean isGreaterThan(T o1, T o2) {
		return o1.compareTo(o2) > 0;
	}

	private boolean isEqual(T o1, T o2) {
		return o1.compareTo(o2) == 0;
	}

	private void addLeftChild(BSTNode<T> parent, BSTNode<T> child) {
		child.setParent(parent);
		parent.setLeft(child);
	}

	private void addRightChild(BSTNode<T> parent, BSTNode<T> child) {
		child.setParent(parent);
		parent.setRight(child);
	}

	private boolean isLeftChild(BSTNode<T> node) {
		if (node.getParent() == null)
			return false;
		return node.equals(node.getParent().getLeft());
	}
}
