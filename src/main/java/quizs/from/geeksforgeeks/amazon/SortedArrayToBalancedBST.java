package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.

 * Examples:
 * --------
        Input:  Array {1, 2, 3}
        Output: A Balanced BST

                 2
               /  \
             1     3

        Input: Array {1, 2, 3, 4}
        Output: A Balanced BST
                3
              /  \
             2    4
            /
           1

 *
 * Algorithm:
 *  Constructing from sorted array in O(n) time is simpler as we can get the middle element in O(1) time.
 *  Following is a simple algorithm where we first find the middle node of list and make it root of the
 *  tree to be constructed.

        1) Get the Middle of the array and make it root.
        2) Recursively do same for left half and right half.
            a) Get the middle of left half and make it left child of the root
                created in step 1.
            b) Get the middle of right half and make it right child of the
                root created in step 1.
 *
 *
 * Created by agebriel on 7/7/17.
 */
public class SortedArrayToBalancedBST
{
	class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	static Node root;

	/* A function that constructs Balanced Binary Search Tree
	 from a sorted array */
	Node sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
		if (start > end) {
			return null;
		}

        /* Get the middle element and make it root */
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
		node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
		node.right = sortedArrayToBST(arr, mid + 1, end);

		return node;
	}

	/* A utility function to print preorder traversal of BST */
	void preOrder(Node node) {
		if (node == null) {
			return;
		}

		preOrder(node.left);
		System.out.print(node.data + " ");
		preOrder(node.right);
	}

	public static void main(String[] args) {
		SortedArrayToBalancedBST tree = new SortedArrayToBalancedBST();
		//int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
		int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7,10};

		root = tree.sortedArrayToBST(arr, 0, arr.length - 1);
		System.out.println("Pre-order traversal of constructed BST");
		tree.preOrder(root);
	}
}
