/**
  * Created by Ayyad Shenouda on 30/3/2016.
  * test for Deque data structre linked list based. 
  */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestLinkedListDeque1B {

 	@Test
 	public void testAll() {
 		StudentLinkedListDeque<Integer> actuial = new StudentLinkedListDeque<Integer>();
 		LinkedListDequeSolution<Integer> expected = new LinkedListDequeSolution<Integer>();
 	 	String massage = "Running tests :\n===========================\n";

 		expected.addFirst(2);
 		actuial.addFirst(2);
 		massage += "addFirst(2)\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());
 		
 		expected.addFirst(4);
 		actuial.addFirst(6);
 		massage += "addFirst(6)\n";

 		expected.addLast(5);
 		actuial.addLast(5);
 		massage +="addLast(5)\n";


 		expected.removeLast();
 		actuial.removeLast();
 		massage += "removeLast()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		expected.removeLast();
 		actuial.removeLast();
 		massage += "removeLast()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		expected.removeFirst();
 		actuial.removeFirst();
 		massage += "removeFirst()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		expected.addLast(14);
 		actuial.addLast(14);
 		massage += "addLast(14)\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		expected.removeFirst();
 		actuial.removeFirst();
 		massage += "removeFirst()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());
 		
 		expected.removeFirst();
 		actuial.removeFirst();
 		massage += "removeFirst()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 	 	expected.addFirst(14);
 		actuial.addFirst(14);
 		massage += "addFirst(14)\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		massage += "isEmpty()\n";
 		assertEquals(massage, expected.isEmpty(), actuial.isEmpty());

 		massage += "get(0)\n";
 		assertEquals(massage, expected.get(0), actuial.get(0));

 		expected.addFirst(1);
 		actuial.addFirst(1);
 		massage += "addFirst(1)\n";

 		expected.addFirst(2);
 		actuial.addFirst(2);
 		massage += "addFirst(2)\n";

 		expected.addFirst(3);
 		actuial.addFirst(3);
 		massage += "addFirst(3)\n";

 		expected.addFirst(4);
 		actuial.addFirst(4);
 		massage += "addFirst(4)\n";

 		expected.addFirst(5);
 		actuial.addFirst(5);
 		massage += "addFirst(5)\n";

 		expected.addFirst(6);
 		actuial.addFirst(6);
 		massage += "addFirst(6)\n";

 		expected.addLast(100);
 		actuial.addLast(100);
 		massage += "addLast(100)\n";

 		expected.addLast(100);
 		actuial.addLast(100);
 		massage += "addLast(100)\n";

 		expected.addLast(102);
 		actuial.addLast(102);
 		massage += "addLast(102)\n";

 		expected.addLast(104);
 		actuial.addLast(104);
 		massage += "addLast(104)\n";

 		expected.addLast(106);
 		actuial.addLast(106);
 		massage += "addLast(106)\nsize()";
 		assertEquals(massage, expected.size(), actuial.size());
 		}
 	public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", TestLinkedListDeque1B.class);
    }
}