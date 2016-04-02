/**
  * Created by Ayyad Shenouda on 30/3/2016.
  * test for Deque data structre array based. 
  */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
 	@Test
 	public void testAll() {
 		StudentArrayDeque<Integer> actuial = new StudentArrayDeque<Integer>();
 		ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<Integer>();
 		String massage = "Running tests :\n===========================\n";


 		actuial.addFirst(4);
 		expected.addFirst(4);
 		massage += "addFirst(4)\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());
 		
 		actuial.addLast(6);
 		expected.addLast(6);
 		massage += "addLast(6)\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());
 		
 		actuial.removeFirst();
 		expected.removeFirst();
 		massage += "removeFirst()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());
 		
 		actuial.removeLast();
 		expected.removeLast();
 		massage += "removeLast()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());
 		
 		actuial.removeFirst();
 		expected.removeFirst();
 		massage += "removeFirst()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		actuial.addLast(5);
 		expected.addLast(5);
 		massage += "addLast(5)\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		actuial.addLast(14);
 		expected.addLast(14);
 		massage += "addLast(14)\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		actuial.removeFirst();
 		expected.removeFirst();
 		massage += "removeFirst()\nsize()\n";
 		assertEquals(massage, expected.size(), actuial.size());

 		}
 	public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", TestArrayDeque1B.class);
    }
 }