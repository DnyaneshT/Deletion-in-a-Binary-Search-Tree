class bst {

	class Node {
		int data;
		Node left, right;
	}

	Node createNode(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.left = null;
		newNode.right = null;
		return newNode;
	}

	Node insert(Node root, int data) {
		if (root == null)
			return createNode(data);

		if (data < root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);

		return root;
	}

	// inorder recursive traversal
	void inorder(Node temp) {
		if (temp == null)
			return;
		inorder(temp.left);
		System.out.println(temp.data);
		inorder(temp.right);

	}

	// predecessor of a node (largest from the left subtree)
	Node predecessor(Node root) {
		Node t = root.left;
		while (t.right != null) {
			t = t.right;
		}
		return t;
	}

	// delete
	Node delete(Node root, int key) {
		// if root is null
		if (root == null)
			return root;

		// find the node with data = key in left subtree
		if (key < root.data)
			root.left = delete(root.left, key);

		// find the node with data = key in right subtree
		else if (key > root.data)
			root.right = delete(root.right, key);

		// you found the node
		else {
			// node with no children
			if (root.left == null && root.right == null)
				return (root = null);

			// node with right child only
			if (root.left == null)
				root = root.right;
			// node with left child only
			else if (root.right == null)
				root = root.left;

			// node with two children
			// replace root.data with the inorder predecessor
			// (largest in the left subtree)
			else {
				Node temp = predecessor(root);
				root.data = temp.data;
				root.left = delete(root.left, temp.data);
			}

		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		bst b = new bst();
		Node root = null;

		root = b.insert(root, 100);
		root = b.insert(root, 50);
		root = b.insert(root, 200);
		root = b.insert(root, 150);
		root = b.insert(root, 300);
		root = b.insert(root, 25);
		root = b.insert(root, 75);
		root = b.insert(root, 12);
		root = b.insert(root, 37);
		root = b.insert(root, 125);
		root = b.insert(root, 175);
		root = b.insert(root, 250);
		root = b.insert(root, 320);
		root = b.insert(root, 67);
		root = b.insert(root, 87);
		root = b.insert(root, 94);
		root = b.insert(root, 89);
		root = b.insert(root, 92);
		root = b.insert(root, 88);

		System.out.println("Before Deletion :");
		b.inorder(root);

		b.delete(root, 100);

		System.out.println("After Deletion : ");
		b.inorder(root);
	}

}

/*
 *Before Deletion :
12
25
37
50
67
75
87
88
89
92
94
100
125
150
175
200
250
300
320
root:89
root:87
root:75
root:50
root:94
After Deletion : 
12
25
37
50
67
75
87
88
89
92
94
125
150
175
200
250
300
320
*/
