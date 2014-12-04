import junit.framework.TestCase;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 24.10.14
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class LoadFilesTest extends TestCase {

    private Set<String> fileNames = new HashSet<String>();

    public void testLoadFileNames(){

        long timeBefore;

        timeBefore = System.currentTimeMillis();
        addFilesInSet(new File("C:/development"));
        System.out.println("Time: " + (System.currentTimeMillis() - timeBefore));
        System.out.println("Size: " + fileNames.size());

    }

    public void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

    public void addFilesInSet(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                addFilesInSet(fileEntry);
            } else {
                fileNames.add(fileEntry.getName());
            }
        }
    }



}
