package cp213;

/**
 *  Implements a Binary Search Tree.
 *
 * @author Kush Rabadia Kantilal Nanji 
 *
 * @version 2019-01-26
 *
 * @param <T> The data to store in the tree.
 */
public class PopularityTree<T extends Comparable<T>> extends BST<T> {

	public PopularityTree() {
		super();
	}

	/**
	 * Inserts data into this BST.
	 *
	 * @param data
	 *            Data to store.
	 */
	@Override
	public void insert(T data) {

		root = insert_aux(root, data);
	}

	/**
	 * Inserts the key-value pair in the subtree. It overrides the old value
	 * with the new value if the symbol table already contains the specified key
	 * and deletes the specified key (and its associated value) from this symbol
	 * table if the specified value is {@code null}.
	 * 
	 * @param x
	 *            the subtree
	 * @param key
	 *            the key
	 * @param val
	 *            the value
	 * @return the subtree
	 */
	public TreeNode<T> insert_aux(TreeNode<T> node, T data) {

		if (node == null) {
			node = new TreeNode<T>(data);
			size += 1;
		} else if (node.getData().compareTo(data) > 0) {
			node.setLeft(insert_aux(node.getLeft(), data));
		}

		else if (node.getData().compareTo(data) < 0) {
			node.setRight(insert_aux(node.getRight(), data));
		} else {
			node.incrementCount();
		}
		node = balance(node);
		node.updateHeight();

		return node;
	}

	private TreeNode<T> balance(TreeNode<T> node) {
		if (node != null && node.getRight() != null) {
			if (node.getRight().getCount() > node.getCount()) {
				node = rotateLeft(node);
			}
		} else if (node != null && node.getLeft() != null) {
			if (node.getLeft().getCount() > node.getCount()) {
				node = rotateRight(node);
			}
		}
		return node;
	}

	/**
	 * Rotates a specific area of nodes in a tree left. root is the unbalanced
	 * node, rChild is it's right child.
	 * 
	 * returns the new root for reattachment reattach either by setting
	 * this.root = this.rotateLeft or by taking the parent node and
	 * .setRight(this.rotateLeft)
	 * 
	 * @param node
	 * @return
	 */
	private TreeNode<T> rotateLeft(TreeNode<T> node) {
		TreeNode<T> child_right = node.getRight();
		node.setRight(child_right.getLeft());
		child_right.setLeft(node);

		node.updateHeight();
		child_right.updateHeight();

		return child_right;
	}

	/**
	 * Rotates a specific area of nodes in a tree right. root is the unbalanced
	 * node, lChild is it's right child.
	 * 
	 * returns the new root for reattachment reattach either by setting
	 * this.root = this.rotateRight or by taking the parent node and
	 * .setLeft(this.rotateRight)
	 * 
	 * @param node
	 * @return
	 */
	private TreeNode<T> rotateRight(TreeNode<T> node) {
		TreeNode<T> child_left = node.getLeft();
		node.setLeft(child_left.getRight());
		child_left.setRight(node);

		node.updateHeight();
		child_left.updateHeight();

		return child_left;
	}
	
	/**
     * Determines if this BST is a valid BST; i.e. a node's left child data is
     * smaller than its data, and its right child data is greater than its data.
     * The height of a node is equal to the maximum of the heights of its two
     * children (missing child nodes have a height of 0), plus 1.
     *
     * @return true if this BST is a valid BST, false otherwise.
     */
	@Override
    public boolean isValid() {

		boolean valid;
		valid = this.isValidAux(this.root);
		return valid;

    }
    
    public boolean isValidAux(TreeNode<T> node1) {
    	boolean valid = true;
    	
    	if(node1==null)
    		valid = true;
    	else if(node1.getLeft()!=null && node1.getLeft().getData().compareTo(node1.getData())>=0)
    		valid = false;
    	else if (node1.getRight()!=null && node1.getRight().getData().compareTo(node1.getData())<=0)
    		valid = false;
    	else {
    		valid = this.isValidAux(node1.getLeft()) && this.isValidAux(node1.getRight());
    	}
    
    	return valid;
    }
    
	/**
     * Get number of comparisons executed by the {@code retrieve} method.
     *
     * @return comparisons
     */
    public int getComparisons() {
	return super.getComparisons();
    }

}
	
