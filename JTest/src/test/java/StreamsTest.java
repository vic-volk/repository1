import junit.framework.TestCase;
import streams.Streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 18.11.14
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
public class StreamsTest extends TestCase {

    public void testInputStream() throws IOException {

        File file = new File("pom.xml");
        byte[] buffer = new byte[1024];

        System.out.println(file.exists());

        String fileContent;
        FileInputStream fileInputStream = new FileInputStream(file);

        try {

            fileInputStream.read(buffer);
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        fileContent = new String(buffer);

        System.out.println(fileContent);

    }

    public void testStreams(){

        Streams.test();

    }

}
