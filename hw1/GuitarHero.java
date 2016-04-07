/** A client that uses the synthesizer package to replicate a plucked guitar string sound
 *  and print charcater on the terminal. 
 */
public class GuitarHero {

    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static void main(String[] args) {
        /* create 37 guitar strings. */
        synthesizer.GuitarString[] strings = new synthesizer.GuitarString[37];
        
        for (int i = 0; i < 37; ++i) {
            strings[i] = new synthesizer.GuitarString(440.0 * Math.pow(2, (i - 24) / 12.0));
        }

        boolean play = false;
        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = Character.toLowerCase(StdDraw.nextKeyTyped());
                int index = keyboard.indexOf(key);
                if (index > -1) {
                    strings[index].pluck();
                    play = true;
                }
            }

             /* compute the superposition of samples */
            double sample = 0;
            for (synthesizer.GuitarString string : strings) {
                sample += string.sample();
            }

            /* play the sample on standard audio */
            if (play == true) {
                StdAudio.play(sample);
            }
            /* advance the simulation of each guitar string by one step */
            for (synthesizer.GuitarString string : strings) {
                string.tic();
            }
        }
    }
}


