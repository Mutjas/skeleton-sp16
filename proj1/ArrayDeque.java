/**
  * Created by Ayyad Shenouda on 30/3/2016.
  * Deque data structre array based. 
  */
public class ArrayDeque<type> {
	private int size;
	private int nextFirst;
	private int nextLast;
	private type[] items;

	/* constructor for the ArrayDeque class witch take no argument. */ 
	public ArrayDeque(){
		size = 0;
		nextFirst = 4;
		nextLast = 5;
		items = (type[]) new Object[8];
	}

	/* add at the first of the deque. */
	public void addFirst(type item) {
		/* if the deque full call resize function that double the capacity of the array. */
		if (size == items.length) {
			resize(items.length * 2);
		}
		items[nextFirst] = item;
		if (nextFirst == 0) {
			nextFirst = items.length - 1;
		}else {
			nextFirst -= 1;
		}
		size += 1;
	}

	/*add at the last of the deque. */
	public void addLast(type item) {
		/* if the deque full call resize function that double the capacity of the array. */
		if(size == items.length) {
			resize(items.length * 2);
		}
		items[nextLast] = item;
		if(nextLast + 1 == items.length) {
			nextLast = 0;
		}else {
			nextLast += 1;
		}
		size += 1;
	}
	
	/* remove the first item in the deque. */ 
	public type removeFirst() {
		if (size == 0) {
			return null;
		}
		nextFirst = firstIndex();
		size -= 1;
		/* if the used percent of the array size is less than 25% decrease the array to the half. */
		if (size / (double)items.length < 0.25) {
			resize(items.length / 2);
		}
		return items[nextFirst];
	}

	/* remove the last item in the deque. */ 
	public type removeLast() {
		if (size == 0) {
			return null;
		}
		nextLast = lastIndex();
		/* if the used percent of the array size is less than 25% decrease the array to the half. */
		if (size / (double)items.length < 0.25) {
			resize(items.length / 2);
		}
		size -= 1;
		return items[nextLast];
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

	/* get the the elemnt in index "index" at the deque. */
	public type get(int index) {
		if (index < 0 || index >= size) {
			return null;		
		}

		index += firstIndex();
		if (index >= items.length) {
			return items[index - size];
		}
		return items[index];
	}

	/* print all the elemnts in the deque. */
	public void printDeque() {
		int index = firstIndex();
		int lastIndex = lastIndex();
		while (index != lastIndex) {
			System.out.print(items[index] + " ");
			index = nextIndex(index, items.length);
		}
		System.out.println(items[lastIndex()]);
	}

	/* helper method to retun index of the last elemnt in the deque. */
	private int lastIndex() {
		if (nextLast == 0) {
			return items.length - 1;		
		}
		return nextLast - 1;
	}

	/* helper method to retun index of the first elemnt in the deque. */	
	private int firstIndex() {
		if (nextFirst + 1 == items.length) {
			return 0;
		}
		return nextFirst + 1;
	}

	/* return the next index for any circular array. */
	private int nextIndex(int index, int length) {
		if (index + 1 == length) {
			return 0;
		}
		return index + 1;
	}

	/*return the capacity or the size of the array not the deque. */
	public int capacity() {
		return items.length;
	}

	/* resize the array to new capacity. */
	private void resize(int newSize) {
		type[] tmp = (type[]) new Object[newSize];
		int itemsIndex = firstIndex();
		int tmpIndex = newSize / 2;
		
		do {
			tmp[tmpIndex] = items[itemsIndex];
			items[itemsIndex] = null;
			itemsIndex = nextIndex(itemsIndex, items.length);
			tmpIndex = nextIndex(tmpIndex, newSize);
		}while (itemsIndex != nextLast);

		items = tmp;
		nextFirst = newSize / 2 - 1;
		nextLast = tmpIndex;
	}
}