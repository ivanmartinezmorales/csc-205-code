## Heaps

## Review deleting from a binary search tree.
### There are three different algorithms, deleting one that has no children
If you're going to delete the node with no children in it, do not just simply cross it out. Show the instructor what the tree looks like after the thing has been deleted. Change the link that the node points to to null 

### Deleting one with one child
Instead of pointing at the 25, point at the 23. Point at the child node of that root node on that given subtree.

### Deleting one with two children
Deleting a node with two children, then cross out the root node of that given subtree, and then find the number that wouldbe in front of the 10, so go left, then right right right right until you get to the 10. Delete the subtree, andthen you put it in the place of the first deleted node.

You're going to be deleting two nodes, not just the original one, but the node that you're going to replace it with. That's basically it.
