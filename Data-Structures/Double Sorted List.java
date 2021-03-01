package cp213;

/**
 * A simple linked sorted list structure of <code>T</code> objects. Only the
 * <code>T</code> value contained in the sorted list is visible through the
 * standard sorted list methods. Extends the <code>DoubleLink</code> class,
 * which already defines the front node, rear node, length, isEmpty, and
 * iterator.
 *
 * @author - Kush Rabadia Kantilal Nanji-
 * @author David Brown
 * @version 2020-06-21
 *
 * @param <T>
 *            this value structure value type.
 */
public class DoubleSortedList<T extends Comparable<T>> extends DoubleLink<T> {

    /**
     * Removes duplicates from this List. The list contains one and only one of
     * each value formerly present in this List. The first occurrence of each
     * value is preserved.
     */
    public void clean() {
    	DoubleList<T> temp = new DoubleList<T>();
    	DoubleNode<T> previous = null;
    	DoubleNode<T> current = this.front;
		while(current != null) {
			T val = temp.find(current.getValue());
			
			if(val== null) {
				temp.append(current.getValue());
				previous = current;
			}else {
				this.remove(val);
			}
			
			current = current.getNext();
			
			if(current == null)
				rear = previous;
			
		}
    }

    /**
     * Combines contents of two lists into a third. Values are alternated from
     * the source lists into this List, but the sorted order is preserved. The
     * source lists are empty when finished. NOTE: value must not be moved, only
     * nodes.
     *
     * @param source1
     *            The first list to combine with this List.
     * @param source2
     *            The second list to combine with this List.
     */
    public void combine(final DoubleSortedList<T> source1,
	    final DoubleSortedList<T> source2) {
    	while(source1.front != null && source2.front != null) {
			this.insert(source1.removeFront());
			this.insert(source2.removeFront());
		}
		
		while( source1.front != null) 
			this.insert(source1.removeFront());
		
		while( source2.front != null) 
			this.insert(source2.removeFront());
		
		return;
    }

    /**
     * Determines if this SortedList contains key.
     *
     * @param key
     *            The key value to look for.
     * @return true if key is in this SortedList, false otherwise.
     */
    public boolean contains(final T key) {
    	if(find(key) == null) 
    		return false;
    	else
    		return true;
    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key
     *            The value to look for.
     * @return The number of times key appears in this SortedList.
     */
    public int count(final T key) {
    	int count = 0;
		DoubleNode<T> current = this.front;
		while(current != null) {
			if(current.getValue()== key)
				count++;
			current = current.getNext();
		}
		return count;
    }

    /**
     * Finds and returns the value in list that matches key.
     *
     * @param key
     *            The value to search for.
     * @return The value that matches key, null otherwise.
     */
    public T find(final T key) {
    	DoubleNode<T> current = this.front;
		while(current != null) {
			if(current.getValue()== key)
				return current.getValue();
			current = current.getNext();
		}
		
		return null;
    }

    /**
     * Get the nth item in this SortedList.
     *
     * @param n
     *            The index of the item to return.
     * @return The nth item in this SortedList.
     * @throws ArrayIndexOutOfBoundsException
     *             if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {
    	DoubleNode<T> current = this.front;
    	int count = 0;
		while(count++ != n+1)
			current = current.getNext();
		
		return current.getValue();
    }

    /**
     * Finds the location of a value by key in list.
     *
     * @param key
     *            The value to search for.
     * @return The index of key in this SortedList, -1 otherwise.
     */
    public int index(final T key) {
    	int count = 0;
		DoubleNode<T> current = this.front;
		while(current.getValue() != key) {
			count++;
			current = current.getNext();
		}
		return count;
    }

    /**
     * Inserts value into this SortedList. Order is preserved.
     *
     * @param value
     *            The new value to insert into this SortedList.
     */
    public void insert(final T value) {

    	DoubleNode<T> node =  new DoubleNode<T>(value,null,null);
    	
    	if(this.length == 0) {
    		this.rear = node;
    		this.front = node;
    	
    	}else if ((int)value<(int)this.front.getValue()){
    		node.setNext(front);
    		this.front.setPrev(node);
    		this.front = node;
    	}else if ((int)value>=(int)this.rear.getValue()){
    		node.setPrev(rear);
    		this.rear.setNext(node);
    		this.rear = node;
    	} else {
    		DoubleNode<T> prev = null;
    		DoubleNode<T> current = this.front;
    		
    		while((int)value>=(int)current.getValue()) {
    			prev = current;
    			current = current.getNext();
    		}
    		
    		prev.setNext(node);
    		current.setPrev(node);
    		node.setNext(current);
    		node.setPrev(prev);
    	}
    	
    	
    	this.length +=1;
    }

    /**
     * Creates an intersection of two other Lists into this SortedList. Copies
     * value to this SortedList. left and right Lists are unchanged.
     *
     * @param left
     *            The first List to create an intersection from.
     * @param right
     *            The second List to create an intersection from.
     */
    public void intersection(final DoubleSortedList<T> left,
	    final DoubleSortedList<T> right) {
        	DoubleNode<T> current =left.front;
        	
        	while(current!= null){
        		T val = current.getValue();
        		
        		T found = right.find(val);
        		
        		if(found!=null) {
        			found = this.find(val);
        			if(found==null) {
        				this.insert(val);
        			}
        		}
        			
        		current = current.getNext();
        	}
    }

    /**
     * Determines whether two lists are identical.
     *
     * @param that
     *            The list to compare against this SortedList.
     * @return true if this SortedList contains the same values in the same
     *         order as that, false otherwise.
     */
    public boolean isIdentical(final DoubleSortedList<T> that) {
    	boolean identical;
		if (this.length!=that.length)
			identical = false;
		else {
			DoubleNode<T> source_node = this.front;
			DoubleNode<T> target_node = that.front;
			
			while(source_node!=null && (target_node.getValue()== source_node.getValue())) {
				source_node = source_node.getNext();
				target_node = target_node.getNext();
			}
			
			identical = (source_node==null);
		}
		return identical;
    }

    /**
     * Finds the maximum value in this SortedList.
     *
     * @return The maximum value.
     */
    public T max() {
    	T max_data = this.front.getValue();
    	DoubleNode <T> current = this.front.getNext();
    	
    	while(current!=null) {
    		if((int)current.getValue() >(int) max_data)
    			max_data = current.getValue();
    		current = current.getNext();
    	}
    	
    	return max_data;
    }

    /**
     * Finds the minimum value in this SortedList.
     *
     * @return The minimum value.
     */
    public T min() {
    	T min_data = this.front.getValue();
    	DoubleNode <T> current = this.front.getNext();
    	
    	while(current!=null) {
    		if((int)current.getValue() <(int) min_data)
    			min_data = current.getValue();
    		current = current.getNext();
    	}
    	
    	return min_data;
    }

    /**
     * Finds, removes, and returns the value in this SortedList that matches
     * key.
     *
     * @param key
     *            The value to search for.
     * @return The value matching key, null otherwise.
     */
    public T remove(final T key) {
    	T val = this.find(key);
    	if(val == null)
    		return null;
    	else {
    		int index = this.index(key);
    		if(index == 0) {

    		} else {
    			DoubleNode<T> prev =null;
    			DoubleNode<T> current =this.front;
    			int j = 0;
    			while(j<index) {
    				prev = current;
	    			current = current.getNext();
	    			j+=1;
    			}
    			prev.setNext(current.getNext());
    			current.getNext().setPrev(prev);
    			if(prev.getNext()==null)
    				this.rear = prev;
    		}
    		this.length--;
    	}
    	return null;
    }

    /**
     * Removes and returns the value at the front of the list.
     *
     * @return the value that has been removed.
     */
    public T removeFront() {
    	T value = this.front.getValue();
		front = front.getNext();
		if(this.length == 1)
			rear = null;
		else
			front.setPrev(null);
		this.length -= 1;
		return value;
    }

    /**
     * Finds and removes all values in this SortedList that match key.
     *
     * @param key
     *            The value to search for.
     */
    public void removeMany(final T key) {
    	DoubleNode<T> prev =null;
		DoubleNode<T> current =this.front;
		
		while(current!=null) {
			if(this.front.getValue() == key) {
				front = front.getNext();
    			if(this.length == 1)
    				rear = null;
    			else
    				front.setPrev(null);
    			this.length--;
			} else if(current.getValue()==key) {
				prev.setNext(current.getNext());
    			current.getNext().setPrev(prev);
    			if(prev.getNext()==null)
    				this.rear = prev;
    			this.length--;
			}
			prev = current;
			current = current.getNext();
		}
		
    }

    /**
     * Removes and returns the value at the rear of the list.
     *
     * @return the value that has been removed.
     */
    public T removeRear() {
    	T value = this.rear.getValue();
		rear = rear.getPrev();
		if(this.length == 1) 
			front = null;
		else
			rear.setNext(null);
		this.length -= 1;
		return value;
    }

    /**
     * Splits the contents of this List into the target Lists. Moves nodes only
     * - does not move value or call the high-level methods insert or remove.
     * this List is empty when done. The first half of this List is moved to
     * target1, and the last half of this List is moved to target2. If the
     * resulting lengths are not the same, target1 should have one more element
     * than target2.
     *
     * @param target1
     *            The first List to move nodes to.
     * @param target2
     *            The second List to move nodes to.
     */
    public void split(final DoubleSortedList<T> target1,
	    final DoubleSortedList<T> target2) {

    	boolean left = true;
    	
    	while(this.front != null) {
    		if(left) {
    			T value = this.front.getValue();
    			this.front = front.getNext();
    			if(this.length == 1)
    				this.rear = null;
    			else
    				this.front.setPrev(null);
    			this.length -= 1;
    			
    			DoubleNode<T> node = new DoubleNode<T>(value,null,null);
    	    	
    			if(target1.length == 0)
    	    		target1.front = node;
    	    	else {
    	    		node.setPrev(rear);
    	    		target1.rear.setNext(node);
    	    	}
    	    	target1.rear = node;
    	    	target1.length+=1;
    		}
    		else {
    			T value = this.front.getValue();
    			this.front = front.getNext();
    			if(this.length == 1)
    				this.rear = null;
    			else
    				this.front.setPrev(null);
    			this.length -= 1;
    			
    			DoubleNode<T> node = new DoubleNode<T>(value,null,null);
    	    	
    			if(target2.length == 0)
    	    		target2.front = node;
    	    	else {
    	    		node.setPrev(rear);
    	    		target2.rear.setNext(node);
    	    	}
    	    	target2.rear = node;
    	    	target2.length+=1;
    		}
    		left = !left;
    	}
    	
    	return;
    }

    /**
     * Splits the contents of this List into the target Lists. Moves nodes only
     * - does not move value or call the high-level methods insert or remove.
     * this List is empty when done. Nodes are moved alternately from this List
     * to target1 and target2.
     *
     * @param target1
     *            The first List to move nodes to.
     * @param target2
     *            The second List to move nodes to.
     */
    public void splitAlternate(final DoubleSortedList<T> target1,
	    final DoubleSortedList<T> target2) {

    	boolean left = true;
		
		while (this.front != null) {
			DoubleNode<T> node = this.front;
			this.length--;
			this.front = this.front.getNext();
			
			if(this.front == null)
				this.rear = null;
			if(left) {
				if(target1.rear == null)
					target1.front = node;
				else
					target1.rear.setNext(node);
				
				node.setNext(null);
				target1.rear = node;
				target1.length++;
			} else {
				if(target2.rear == null)
					target2.front = node;
				else
					target2.rear.setNext(node);
				
				node.setNext(null);
				target2.rear = node;
				target2.length++;
				
			}
			
			left=!left;
		}

    }

    /**
     * Creates a union of two other Lists into this SortedList. Copies value to
     * this list. left and right Lists are unchanged.
     *
     * @param left
     *            The first List to create a union from.
     * @param right
     *            The second List to create a union from.
     */
    public void union(final DoubleSortedList<T> left,
	    final DoubleSortedList<T> right) {

    	DoubleNode<T> node1 = left.front;
		
		while(node1!=null) {
			T val = node1.getValue();
			T val1 = this.find(val);
			
			if(val1== null) {
				DoubleNode<T> node = new DoubleNode<T>(val,null,null);
		    	if(this.length == 0)
		    		front = node;
		    	else {
		    		node.setPrev(rear);
		    		rear.setNext(node);
		    	}
		    	rear = node;
		    	this.length+=1;
			}
			
			node1 = node1.getNext();
				
		}
		
		DoubleNode<T> node2 = right.front;
		
		while(node2!=null) {
			T val = node2.getValue();
			T val1 = this.find(val);
			
			if(val1== null) {
				DoubleNode<T> node = new DoubleNode<T>(val,null,null);
				if(this.length == 0)
					front = node;
				else {
					node.setPrev(rear);
					rear.setNext(node);
				}
				rear = node;
				this.length+=1;
			}
			
			node2 = node2.getNext();
			
		}
    }
    
    public static void main(final String[] args) {
    	DoubleSortedList<Integer> source1 = new DoubleSortedList<Integer>();
    	DoubleSortedList<Integer> source2 = new DoubleSortedList<Integer>();

    	DoubleSortedList<Integer> target3 = new DoubleSortedList<Integer>();
    	DoubleSortedList<Integer> target4 = new DoubleSortedList<Integer>();
    	DoubleSortedList<Integer> queue = new DoubleSortedList<Integer>();
    	DoubleSortedList<Integer> interqueue = new DoubleSortedList<Integer>();
    	
    	source1.insert(1);
    	source2.insert(2);
    	source1.insert(3);
    	source2.insert(4);
    	source1.insert(5);
    	source1.insert(5);
    	source2.insert(6);
    	
    	source1.clean();
    	System.out.println("Source1");
    	for(Integer a : source1.toArray()) { System.out.print(a.intValue()); }
    	System.out.printf("\nSource1\n");
    	for(Integer a : source2.toArray()) { System.out.print(a.intValue()); }
    	
    	queue.combine(source1, source2);
    	System.out.printf("\nqueue\n");
    	for(Integer a : queue.toArray()) { System.out.print(a.intValue()); }
    	
    	source1.insert(1);
    	source2.insert(1);
    	source1.insert(2);
    	source2.insert(2);
    	source1.insert(3);
    	source2.insert(3);
    	    	
    	interqueue.intersection(source1, source2);
    	System.out.printf("\nInterqueue\n");
    	for(Integer a : interqueue.toArray()) { System.out.print(a.intValue()); }
    	
    	System.out.println(source1.isIdentical(source2));
    	System.out.println(source1.max());
    	System.out.println(source1.min());
	
    	queue.split(target3,target4);
    	
    	System.out.printf("\ntarget3\n");
    	for(Integer a : target3.toArray()) { System.out.print(a.intValue()); }
    	System.out.printf("\ntarget4\n");
    	for(Integer a : target4.toArray()) { System.out.print(a.intValue()); }
    	
    }
}
