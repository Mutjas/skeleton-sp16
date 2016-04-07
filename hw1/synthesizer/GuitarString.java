package synthesizer;

public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int sizeOfQueue = (int)Math.round (SR/frequency);
        buffer = new ArrayRingBuffer(sizeOfQueue);
        pluck();
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        buffer = new ArrayRingBuffer(buffer.capacity());
        int capacityOfQueue = buffer.capacity();
        for (int i = 0; i < capacityOfQueue; ++i) {
            buffer.enqueue(Math.random() - 0.5);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
       double itemToRun = buffer.dequeue();
        itemToRun = (itemToRun + buffer.peek()) / 2;
        itemToRun = itemToRun * DECAY;
        buffer.enqueue(itemToRun);
    }
    
    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
