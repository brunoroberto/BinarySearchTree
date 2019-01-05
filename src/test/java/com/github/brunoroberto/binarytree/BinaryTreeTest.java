package com.github.brunoroberto.binarytree;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BinaryTreeTest {

	@Test
	public void testBinaryTreeInOrder() {
		List<Integer> expected = Arrays.asList(8, 10, 11, 12, 13);

		BST<Integer> tree = new BinaryTree<>();
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.add(11);
		tree.add(13);

		assertIterableEquals(expected, tree.inOrder());
	}

	@Test
	public void testBinaryTreePreOrder() {
		List<Integer> expected = Arrays.asList(10, 8, 12, 11, 13);

		BST<Integer> tree = new BinaryTree<>();
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.add(11);
		tree.add(13);

		assertIterableEquals(expected, tree.preOrder());
	}

	@Test
	public void testBinaryTreePosOrder() {
		List<Integer> expected = Arrays.asList(8, 12, 11, 13, 10);

		BST<Integer> tree = new BinaryTree<>();
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.add(11);
		tree.add(13);

		assertIterableEquals(expected, tree.posOrder());
	}

	@Test
	public void testBinaryTreeRemove() {
		List<Integer> expected = Arrays.asList(8, 12, 11, 13);

		BST<Integer> tree = new BinaryTree<>();
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.add(11);
		tree.add(13);

		tree.remove(10);

		assertIterableEquals(expected, tree.preOrder());
	}

	@Test
	public void testBinaryTreeAdd() {
		List<Integer> expected1 = Arrays.asList(10, 8, 12, 11, 13);

		BST<Integer> tree = new BinaryTree<>();
		tree.add(10);
		tree.add(8);
		tree.add(12);
		tree.add(11);
		tree.add(13);

		assertIterableEquals(expected1, tree.preOrder());

		List<Integer> expected2 = Arrays.asList(10, 8, 5, 1, 4, 12, 11, 13);
		tree.add(5);
		tree.add(1);
		tree.add(4);

		assertIterableEquals(expected2, tree.preOrder());
	}
}
