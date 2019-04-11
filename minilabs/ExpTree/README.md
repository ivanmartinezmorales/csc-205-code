# Minilab ExpTree

## Notes
What is an AVL tree? a AVL tree is a BST that knows to balance itself. Every node in the AVL tree has a balance factor, and the balance factor is the height of the left subtree, minus the height of the right subtree as such:

> balance_factor = left_subtree - right_subtree 

An AVL tree is considered balanced when every node has a balance factor of 0, 1, or -1.

Let's build an AVL tree. 

Suppose we have our root node, where the balance factor is 0 because it has no left and right nodes. Lets add a new node, which is larger than the previous node. This node will have a balance factor of 0, and its parent node will have a balance node of -1, such that because of child node, the new balance factor of the overall tree is -1.

Now, lets add a 6 to the tree, meaning that the 6 will be on the left side of the subtree. If we add the 6, then the 6 node will have a balance factor of 0, and its parent node will now have a balance factor of zero again as it has equal subtree heights on each side, respectively.

Now, if we add a 5, under our 6 node, it will go on the left. Then the balance factor of the root tree is now 1 as there are more nodes on the left side than the right side.

Now, suppose we add another node 2, under the node 5. The tree is now unbalanced as its balance factor is now 2. If the balance factor is 2, then it is time for the tree to do what its known for, and pivot on the subtree that has the highest balance factor.

Here is a link on AVL trees: https://en.wikipedia.org/wiki/AVL_tree