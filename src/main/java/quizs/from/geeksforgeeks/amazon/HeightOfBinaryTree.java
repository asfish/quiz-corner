package quizs.from.geeksforgeeks.amazon;

/**
 *
 * Iterative Method to find Height of Binary Tree:
 *There are two conventions to define height of Binary Tree
        1) Number of nodes on longest path from root to the deepest node.
        2) Number of edges on longest path from root to the deepest node.
 *
 * Recursive method to find height of Binary Tree is discussed here. How to find height
 * without recursion? We can use level order traversal to find height without recursion.
 * The idea is to traverse level by level. Whenever move down to a level, increment height
 * by 1 (height is initialized as 0). Count number of nodes at each level, stop traversing
 * when count of nodes at next level is 0.
 *
 * Following is detailed algorithm to find level order traversal using queue.

    Create a queue.
    Push root into the queue.
    height = 0
    Loop
    nodeCount = size of queue

    // If number of nodes at this level is 0, return height
    if nodeCount is 0
        return Height;
    else
        increase Height

    // Remove nodes of this level and add nodes of
    // next level
    while (nodeCount > 0)
        pop node from front
        push its children to queue
        decrease nodeCount
        // At this point, queue has nodes of next level
 *
 *
 *
 *
 * http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
 *
 * Created by agebriel on 7/6/17.
 */
public class HeightOfBinaryTree
{

}
