package cp213;

/**
 * A simple linked deque structure of <code>T</code> objects. Only the
 * <code>T</code> value contained in the deque is visible through the standard
 * deque methods. Extends the <code>DoubleLink</code> class, which already
 * defines the front node, rear node, length, isEmpty, and iterator.
 *
 * @author - Kush Rabadia Kantilal Nanji -
 * @author David Brown
 * @version 2019-01-26
 *
 * @param <T>
 *            this data structure value type.
 */
public class DoubleDeque<T> extends DoubleLink<T> {

    /**
     * Adds a value to the front of a deque.
     *
     * @param value
     *            value to add to the front of the deque.
     */
    public void addFront(final T value) {
    	
    	DoubleNode<T> node =  new DoubleNode<T>(value,null,null);
    	
    	if(this.length == 0) 
    		rear = node;
    	else {
    		
    		node.setNext(front);
    		front.setPrev(node);
    	}
    	front = node;
    	
    	this.length +=1;
	return;
    }

    /**
     * Adds a value to the rear of a deque.
     *
     * @param value
     *            value to add to the rear of the deque.
     */
    public void addRear(final T value) {
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
     * Returns the value at the front of a deque.
     *
     * @return the value at the front of the deque.
     */
    public T peekFront() {
    	return front.getValue();
    }

    /**
     * Returns the value at the rear of a deque.
     *
     * @return the value at the rear of the deque.
     */
    public T peekRear() {
		return rear.getValue();
    }

    /**
     * Removes and returns the value at the front of a deque.
     *
     * @return the value that has been removed.
     */
    public T removeFront() {
		T value = peekFront();
		front = front.getNext();
		if(this.length == 1)
			rear = null;
		else
			front.setPrev(null);
		this.length -= 1;
		return value;
    }

    /**
     * Removes and returns the value at the rear of a deque.
     *
     * @return the value that has been removed.
     */
    public T removeRear() {
    	T value = peekRear();
		rear = rear.getPrev();
		if(this.length == 1) 
			front = null;
		else
			rear.setNext(null);
		this.length -= 1;
		return value;
    }
    
    public static void main(final String[] args) {
    	DoubleDeque<Integer> dd = new DoubleDeque<Integer>();
    	
    	dd.addFront(2);
    	dd.addRear(3);
    	dd.addFront(1);
    	dd.addRear(4);
       	dd.removeFront();
       	dd.removeRear();
    	
		for(Integer a : dd.toArray()) { System.out.println(a.intValue()); }
		 
   		System.out.println(dd.front.getNext().getPrev().getValue());
    }
}
