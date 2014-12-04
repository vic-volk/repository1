package streams;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 04.12.14
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class Streams {

    public static void test() {

        File file = new File("C:\\Users\\volkov\\Pictures\\motto.net.ua-40932.jpg");

        OutputStream outputStream1 = new ByteArrayOutputStream();
        OutputStream outputStream2 = new ByteArrayOutputStream();
        OutputStream outputStream3 = new ByteArrayOutputStream();
        OutputStream outputStream4 = new ByteArrayOutputStream();

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);

            byte[] b = new byte[1024];

            while (fileInputStream.read() != -1){
                fileInputStream.read(b);
                outputStream1.write(b);
                fileInputStream.read(b);
                outputStream2.write(b);
                fileInputStream.read(b);
                outputStream3.write(b);
                fileInputStream.read(b);
                outputStream4.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                fileInputStream.close();
                outputStream1.close();
                outputStream2.close();
                outputStream3.close();
                outputStream4.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        }
    }

}
