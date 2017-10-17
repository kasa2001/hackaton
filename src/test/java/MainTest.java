import com.hackaton.finder.WordFinder;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testSth() {
        assertTrue(true);
    }


    /**
     * Method check setting path
     * */
    @Test
    public void testFileManipulatorSetter() {
        WordFinder fm = WordFinder.getInstance();

        fm.setPath("data/temporary.txt");

        assertTrue(fm.getPath().equals("data/temporary.txt"));
    }


    /**
     * Method check sizeof List
     * */
    @Test
    public void testListInWordFinder() {
        WordFinder fm = WordFinder.getInstance();

        fm.prepareKeywords();

        assertTrue(fm.getSize() == 12);
    }

    /**
     * Method check reading file
     * */
    @Test
    public void testReadingInWordFinder() {
        WordFinder fm = WordFinder.getInstance();
        fm.setPath("data/test.txt");
        try {
            assertTrue(fm.readFile() == 2);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
