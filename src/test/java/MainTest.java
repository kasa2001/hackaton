import com.hackaton.finder.WordFinder;
import com.hackaton.microphone.Microphone;
import com.hackaton.microphone.MicrophoneException;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.sound.sampled.AudioFormat;
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
    public void testWordFinderSetter() {
        WordFinder fm = new WordFinder();

        fm.setPath("data/temporary.txt");

        assertEquals(fm.getPath(), "data/temporary.txt");
    }


    /**
     * Method check sizeof List
     * */
    @Test
    public void testListInWordFinder() {
        WordFinder fm = new WordFinder();

        fm.prepareKeywords();

        assertEquals(fm.getSize(),12);
    }

    /**
     * Method check reading file
     * */
    @Test
    public void testReadingInWordFinder() {
        WordFinder fm = new WordFinder();
        fm.setPath("data/test.txt");
        try {
            assertEquals(fm.readFile(),2);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testCreateMicrophone() {
        try {
            new Microphone(new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 20000000, 16, 1, 2, 20000000, true));
        } catch (MicrophoneException e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void testConnection() {
        try {
            Microphone m = new Microphone(new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 20000000, 16, 1, 2, 20000000, true));
            m.openStream();
            m.closeStream();
        } catch (MicrophoneException e) {
            System.err.println(e.getMessage());
        }
    }
}
