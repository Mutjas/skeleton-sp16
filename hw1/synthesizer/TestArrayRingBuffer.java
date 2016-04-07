package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        assertEquals(0 ,arb.fillCount());
        assertEquals(4, arb.capacity());
        
        arb.enqueue(1);
        arb.enqueue(2);
        
        assertEquals(2,arb.fillCount());
        assertEquals(4, arb.capacity());
		assertEquals(1, arb.peek());
        assertEquals(1, arb.dequeue());
        assertEquals(1,arb.fillCount());
        assertEquals(4, arb.capacity());
        assertEquals(2, arb.dequeue());
        assertEquals(0,arb.fillCount());
        assertEquals(4, arb.capacity());

		arb.enqueue(1);
        arb.enqueue(2);
	    arb.enqueue(3);
        arb.enqueue(4);

        assertEquals(1, arb.peek());
        assertEquals(4,arb.fillCount());
        assertEquals(4, arb.capacity());
        assertEquals(1, arb.dequeue());

        assertEquals(2, arb.peek());
        assertEquals(3,arb.fillCount());
        assertEquals(4, arb.capacity());
        assertEquals(2, arb.dequeue());

		assertEquals(3, arb.peek());
        assertEquals(2,arb.fillCount());
        assertEquals(4, arb.capacity());
        assertEquals(3, arb.dequeue());

        assertEquals(4, arb.peek());
        assertEquals(1,arb.fillCount());
        assertEquals(4, arb.capacity());
        assertEquals(4, arb.dequeue());

		assertEquals(0,arb.fillCount());
        assertEquals(4, arb.capacity());
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(4);
    
        arb.enqueue(1);
        arb.enqueue(2);
        
        for (int item : arb) {
            System.out.print(item + " ");
        }
        System.out.println();
        
        arb.dequeue();
        for (int item : arb) {
            System.out.print(item + " ");
        }
        System.out.println();
        
        arb.dequeue();
        for (int item : arb) {
            System.out.print(item + " ");
        }
        System.out.println();

        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);

        for (int item : arb) {
            System.out.print(item + " ");
        }
        System.out.println();
        

        arb.dequeue();

        for (int item : arb) {
            System.out.print(item + " ");
        }
        System.out.println();

        arb.dequeue();

        for (int item : arb) {
            System.out.print(item + " ");
        }
        System.out.println();



        arb.dequeue();

        for (int item : arb) {
            System.out.print(item + " ");
        }
        System.out.println();
        

        arb.dequeue();

        for (int item : arb) {
            System.out.print(item + " ");
        }
        System.out.println();

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
