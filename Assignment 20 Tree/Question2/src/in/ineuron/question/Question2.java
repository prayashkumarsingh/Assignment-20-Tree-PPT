package in.ineuron.question;

import java.io.*;

public class Question2 {
	static class Node {
		int data;
		Node left, right;
	};

	static Node getNode(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.left = newNode.right = null;
		return newNode;
	}
	static Node LevelOrder(Node root, int data) {
		if (root == null) {
			root = getNode(data);
			return root;
		}
		if (data <= root.data)
			root.left = LevelOrder(root.left, data);
		else
			root.right = LevelOrder(root.right, data);
		return root;
	}

	static Node constructBST(int arr[], int n) {
		if (n == 0)
			return null;
		Node root = null;

		for (int i = 0; i < n; i++)
			root = LevelOrder(root, arr[i]);

		return root;
	}
	static void inorderTraversal(Node root) {
		if (root == null)
			return;

		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}
	public static void main(String args[]) {
		int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		int n = arr.length;

		Node root = constructBST(arr, n);

		System.out.print("Inorder Traversal: ");
		inorderTraversal(root);
	}
}
