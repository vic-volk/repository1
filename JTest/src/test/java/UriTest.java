import junit.framework.TestCase;
import org.junit.Test;
import strings.uri.Util;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 30.11.14
 * Time: 12:48
 * To change this template use File | Settings | File Templates.
 */
public class UriTest extends TestCase {

    @Test
    public void testParamDeletion(){
        String uri = "http://yandex.ru/folder/pic.jpg/param1=1ffghshsgh";
        uri = Util.removeParameterFromUri(uri, "param1");
        System.out.println("Removing: " + uri);
        uri = "http://yandex.ru/folder/pic.jpg/param2=1ffghshsgh&param1=1ffghshsgh";
        uri = Util.removeParameterFromUri(uri, "param1");
        System.out.println("Removing: " + uri);
        uri = "http://yandex.ru/folder/pic.jpg/param2=1ffghshsgh&param1=1ffghshsgh&param3=1ffghshsgh";
        uri = Util.removeParameterFromUri(uri, "param1");
        System.out.println("Removing: " + uri);
    }

    @Test
    public void testParamAppending(){
        String uri = "http://yandex.ru/folder/pic.jpg";
        uri = Util.addParameterToUri(uri, "param1", "1sghsghsfh");
        System.out.println(uri);
        uri = "http://yandex.ru/folder/pic.jpg?param2=1ffghshsgh";
        uri = Util.addParameterToUri(uri, "param1", "1sghsghsfh");
        System.out.println(uri);
    }

    @Test
    public void testURI() throws URISyntaxException {

        URI uri = new URI("http://postfactor/system.html");
        System.out.println(uri.getPort());
        System.out.println(uri.getHost());

    }

}
