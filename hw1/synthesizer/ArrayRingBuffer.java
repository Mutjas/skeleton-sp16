package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    
   private void first() {
        if (first == capacity) {
            first = 0;
        }
    }

    private void last() {
        if (last == capacity) {
            last = 0;
        }
    }

    @Override
    public void enqueue(T x) {
        if (fillCount == capacity) {
            throw new RuntimeException("Ring Buffer Overflow") ;        
        }
        last();
        rb[last] = x;
        last += 1;
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */

    @Override
    public T dequeue() {
        if (fillCount == 0) {
             throw new RuntimeException("Ring Buffer Underflow") ; 
        }         
        T item = rb[first];
        first += 1;
        first();
        fillCount -= 1;
        return item;
    }

    
    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
         first();
        return rb[first];
    }

    
    private class BufferWizard implements Iterator<T> {
        private int pointerFirst;
        private int countItems;

        public BufferWizard() {
            first();
            pointerFirst = first;
            countItems = 0;
        }

        public boolean hasNext() {
            return (countItems < fillCount);
        }

        public T next() {
            if (pointerFirst == capacity) {
                 pointerFirst = 0;
            }
            T itemToReturn = rb[pointerFirst];
            pointerFirst += 1;
            countItems += 1;
            return itemToReturn;
        }
    }

    @Override    
    public Iterator<T> iterator() {
        return new BufferWizard();
    } 
}
