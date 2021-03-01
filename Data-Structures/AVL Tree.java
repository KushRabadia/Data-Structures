package cp213;

/**
 * Implements an AVL (Adelson-Velsky Landis) tree. Extends BST.
 *
 * @author Kush Rabadia Kantilal Nanji
 * @version 2019-01-26
 *
 * @param <T>
 *            The data to store in the tree.
 */
public class AVL<T extends Comparable<T>> extends BST<T> {
	public AVL() {
		super();
	}


    public int height(TreeNode<T> x)
    {
        if(x == null)
        {
            return 0;
        }
        else
        {
            return x.getHeight();
        }
    }

    public int balanceFactor(TreeNode<T> x)
    {
        if(x == null)
        {
            return 0;
        }
        else
            return (height(x.getLeft()) - height(x.getRight()));
    }

    public TreeNode<T> RightRotate(TreeNode<T> cur)
    {
    	
    	TreeNode<T> y = cur.getLeft();
    	cur.setLeft(y.getRight());
    	y.setRight(cur);

        y.updateHeight();;
        cur.updateHeight();;

        return y;
    }
    public TreeNode<T> LeftRotate(TreeNode<T> cur)
    {
    	TreeNode<T> x = cur.getRight();
        cur.setRight(x.getLeft());
        x.setLeft(cur);

        x.updateHeight();
        cur.updateHeight();
        return x;
    }
    
    @Override
    public void insert(T key)
    {
        root = insertAux(this.root,key);
    }
    @Override
    public TreeNode<T> insertAux(TreeNode<T> cur, T key)
    {
    	TreeNode<T> newNode = new TreeNode<T>(key);
        if(cur == null)       
            return newNode;       
        else if(key.compareTo(cur.getData())<0)
        {
            cur.setLeft(insertAux(cur.getLeft(),key));
        }
        else if(key.compareTo(cur.getData())>0)
        {
            cur.setRight(insertAux(cur.getRight(),key));
        } else 
        	return cur;
        

        cur.updateHeight();
        return balance(cur);   
        
    }
    
    public TreeNode<T> balance(TreeNode<T> cur){
    	if(balanceFactor(cur) >1) {
	        if(balanceFactor(cur.getLeft())<0)
	            cur.setLeft(LeftRotate(cur.getLeft()));
	        cur =  RightRotate(cur);
	        
        }else if(balanceFactor(cur)<-1) {
	        if(balanceFactor(cur.getRight())>0)
	            cur.setRight( RightRotate(cur.getRight()));
	        cur =  LeftRotate(cur);
	        
        }
    	return cur;
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


    public void Find(T key)
    {
        find_aux(this.root,key);
    }
    private void find_aux(TreeNode<T> root,T key)
    {
        if(root == null)
        {
            System.out.println("Sorry Value NOT Found !");
            return;
        }

        if(root.getData().compareTo(key)==0)
        {
            System.out.println(root.getHeight());
            return;
        }
        else if(root.getData().compareTo(key)>0)
        {
            find_aux(root.getLeft(), key);
        }
        else
        {
            find_aux(root.getRight(), key);
        }
    }

    private TreeNode<T> Min(TreeNode<T> root)
    {
        if(root.getLeft() == null)
        {
            return root;
        }
        else
            return Min(root.getLeft());
    }

    public void remove(T key)
    {
        root = remove_aux(root,key);
    }
    private TreeNode<T> remove_aux(TreeNode<T> root, T key)
    {
        if(root == null) return null;
        else if(key.compareTo(root.getData())<0)
        {
            root.setLeft( remove_aux(root.getLeft(),key));
        }
        else if(key.compareTo(root.getData())>0)
        {
            root.setRight(remove_aux(root.getRight(),key)); 
        }
        else
        {
            if(root.getLeft() == null && root.getRight() == null)
            {
                root = null;
            }
            else if(root.getRight() == null)
            {
                root = root.getLeft();
            }
            else if(root.getLeft() == null)
            {
                root = root.getRight();
            } else{
            	TreeNode<T> temp = Min(root.getRight());
                root= temp;
                root.setRight(remove_aux(root.getRight(),temp.getData()));
            }
        }
        if(root == null)
        {
            return root;
        }
        root.updateHeight();
        int Balance = balanceFactor(root);
        if(Balance > 1 && balanceFactor(root.getLeft()) >= 0)
        {
            return RightRotate(root);
        }
        else if(Balance > 1 && balanceFactor(root.getLeft()) < 0)
        {
            root.setLeft(LeftRotate(root.getLeft()));
            return RightRotate(root);
        }
        else if(Balance < -1 && balanceFactor(root.getRight()) <= 0)
        {
            return LeftRotate(root);
        }
        else if(Balance < -1 && balanceFactor(root.getRight()) > 0)
        {
            root.setRight( RightRotate(root.getRight()));
            return LeftRotate(root);
        }
        return root;
    }
}


