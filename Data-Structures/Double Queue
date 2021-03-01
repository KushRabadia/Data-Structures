package cp213;

/**
 * A simple linked queue structure of <code>T</code> objects. Only the
 * <code>T</code> value contained in the queue is visible through the standard
 * queue methods. Extends the <code>DoubleLink</code> class, which already
 * defines the front node, rear node, length, isEmpty, and iterator.
 *
 * @author - Kush Rabadia Kantilal Nanji -
 * @author David Brown
 * @version 2019-06-16
 *
 * @param <T>
 *            this data structure value type.
 */
public class DoubleQueue<T> extends DoubleLink<T> {

    /**
     * Combines the contents of the left and right Queues into the current
     * Queue. Moves nodes only - does not move value or call the high-level
     * methods insert or remove. left and right Queues are empty when done.
     * Nodes are moved alternately from left and right to this Queue.
     *
     * @param source1
     *            The front Queue to extract nodes from.
     * @param source2
     *            The second Queue to extract nodes from.
     */
    public void combine(final DoubleQueue<T> source1,
	    final DoubleQueue<T> source2) {
		while(source1.front != null && source2.front != null) {
			this.insert(source1.remove());
			this.insert(source2.remove());
		}
		
		while( source1.front != null) 
			this.insert(source1.remove());
		
		while( source2.front != null) 
			this.insert(source2.remove());
		
		return;
    }

    /**
     * Adds value to the rear of the queue. Increments the queue size.
     *
     * @param value
     *            The value to added to the rear of the queue.
     */
    public void insert(final T value) {
    	DoubleNode<T> node = new DoubleNode<T>(value,null,null);
    	if(this.length == 0)
    		front = node;
    	else {
    		node.setPrev(rear);
    		rear.setNext(node);
    	}
    	rear = node;
    	this.length+=1;
    	
    	return;
    }

    /**
     * Returns the front value of the queue and removes that value from the
     * queue. The next node in the queue becomes the new front node. Decrements
     * the queue size.
     *
     * @return The value at the front of the queue.
     */
    public T remove() {
    	T value = front.getValue();
		front = front.getNext();
		if(this.length == 1)
			rear = null;
		else
			front.setPrev(null);
		this.length -= 1;
		return value;
    }

    /**
     * Splits the contents of the current Queue into the left and right Queues.
     * Moves nodes only - does not move value or call the high-level methods
     * insert or remove. this Queue is empty when done. Nodes are moved
     * alternately from this Queue to left and right.
     *
     * @param target1
     *            The first Queue to move nodes to.
     * @param target2
     *            The second Queue to move nodes to.
     */
    public void split(final DoubleQueue<T> target1,
	    final DoubleQueue<T> target2) {
    	
    	boolean left = true;
    	
    	while(this.front != null) {
    		if(left)
    			target1.insert(this.remove());
    		else
    			target2.insert(this.remove());
    		left = !left;
    	}
    	
    	return;
    }
    
    public static void main(final String[] args) {
    	DoubleQueue<Integer> source1 = new DoubleQueue<Integer>();
    	DoubleQueue<Integer> source2 = new DoubleQueue<Integer>();
    	DoubleQueue<Integer> target1 = new DoubleQueue<Integer>();
    	DoubleQueue<Integer> target2 = new DoubleQueue<Integer>();
    	DoubleQueue<Integer> queue = new DoubleQueue<Integer>();
    	
    	source1.insert(1);
    	source2.insert(2);
    	source1.insert(3);
    	source2.insert(4);
    	source1.insert(5);
    	source2.insert(6);
    	
    	queue.combine(source1, source2);
    	
    	for(Integer a : queue.toArray()) { System.out.println(a.intValue()); }
    	
    	queue.split(target1, target2);
    	
    	for(Integer a : target1.toArray()) { System.out.println(a.intValue()); }
    	for(Integer a : target2.toArray()) { System.out.println(a.intValue()); }
		 
    }
}
