/**
  * Created by Ayyad Shenouda on 2/4/2016.
  * interface for LinkedListDeque and ArrayDeque. 
  */

public interface Deque<type> {
	public void addFirst(type item);
	public void addLast(type item);
	public type removeFirst();
	public type removeLast();
	public boolean isEmpty();
	public int size();
	public type get(int index);
	public void printDeque();
}