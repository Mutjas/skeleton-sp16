/**
  * Created by Ayyad Shenouda on 30/3/2016.
  * Deque data structre linked list based. 
  */
public class LinkedListDeque <type> {
	
	/* make the Node class that class will hold the data. */ 
	private class Node {
		private Node previous;  
		private type item;
		private Node next;		

		/*constructor for the Node class take 3 arguments. */
		public Node(Node previous ,type item, Node next) {
			this.previous = previous;
			this.item = item;
			this.next = next;
		}
	}

	private int size;
	private Node sentinel;
	private Node back;

	/*constructor for the LinkedListDeque witch take no argument. */
	public LinkedListDeque() {
		size = 0;
		sentinel = new Node(null, null, null);
		back = sentinel;
	}

	/* add item at the front of the Deque actualy we add it back sentinel node. */
	public void addFirst(type item) {
		if (size == 0) {
			addLast(item);
			return;
		}
		Node itemToInsert = new Node(sentinel, item, sentinel.next);
		sentinel.next.previous = itemToInsert;
		sentinel.next = itemToInsert;
		size += 1;
	}


	/* add item at the back of the Deque. */
	public void addLast(type item) {
		Node itemToInsert = new Node(back, item, sentinel);
		back.next = itemToInsert;
		sentinel.previous = itemToInsert;
		back = itemToInsert;
		size += 1;
	}

	/* remove the first node. */
	public type removeFirst() {
		if (size == 0) {
			return null;
		}else if (size == 1) {
			return removeLast();
		}
		Node itemToRemove = sentinel.next;
		sentinel.next = itemToRemove.next;
		itemToRemove.next.previous = sentinel;
		size -= 1;
		itemToRemove.next = null;
		itemToRemove.previous = null;
		return itemToRemove.item;

	}

	/* remove the last node. */
	public type removeLast() {
		if (size == 0) {
			return null;
		}
		Node itemToRemove = back;
		back = itemToRemove.previous;
		sentinel.previous = back;
		back.next = sentinel;
		size -= 1;
		itemToRemove.next = null;
		itemToRemove.previous = null;
		return itemToRemove.item;

	}

	/* return true if the deque empty false otherwise. */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	/* return the size of the deque. */
	public int size() {
		return size;
	}

	/** 
	 *return the item in the given index. 
	 *iterative way.
	 */
	public type get(int index) {
		Node pointer = sentinel.next;
		for (int i = 0; i < size; ++i) {
			if(i == index) {
				return pointer.item;
			}
			pointer = pointer.next;
		}
		return null;
	}

	/**
	 * helper method for getRecursive function .
 	 * the recursive way.
	 */
	private type getRecursiveHelperMethod(int index, Node pointer) {
		if (index == 0) {
			return pointer.item;			
		}
		return getRecursiveHelperMethod(index - 1, pointer.next);
	}

	/** same the get method but in recursive way 
	 *we use getRecursiveHelperMethod to do the recursive part. 
	 */ 
	public type getRecursive(int index) {
		if (index >= size || index < 0) {
			return null;		
		}
		return getRecursiveHelperMethod(index, sentinel.next);
	}

	/* print the deque. */
	public void printDeque() {
		if (size == 0) {
			return ;
		}
		Node pointer = sentinel.next;
		while (pointer.next != sentinel) {
			System.out.print(pointer.item + " ");
			pointer = pointer.next;
		}
		System.out.println(pointer.item);
	}
}