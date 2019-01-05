package com.github.brunoroberto.binarytree;

public class BSTNode<T extends Comparable<T>> {

	private BSTNode<T> parent;
	private BSTNode<T> left;
	private BSTNode<T> right;

	private T key;

	public BSTNode(T key, BSTNode<T> parent) {
		super();
		this.key = key;
		this.parent = parent;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public BSTNode<T> getParent() {
		return parent;
	}

	public void setParent(BSTNode<T> parent) {
		this.parent = parent;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}

	@Override
	public String toString() {
		return "BSTNode [" + key + "]";
	}

}
