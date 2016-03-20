import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by ayyad on 3/20/2016.
 */
public class FlikTest {
    @Test
    public void TestIsSameNummber() {
        int i = 0;
        int j = 0;
        while (i < 500){
            boolean b = Flik.isSameNumber(i, j);
            assertTrue(b);
            ++i;
            ++j;
        }
    }


}
