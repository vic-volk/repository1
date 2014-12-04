package structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 13.11.14
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
public class ManInTheCircle {

    List<Man> men = new ArrayList<Man>();

    int numberOfTheFirst;
    int M;
    int N;

    public ManInTheCircle(int numberOfTheFirst, int m, int n) {

        this.numberOfTheFirst = numberOfTheFirst;
        M = m;
        N = n;

        generateList();

    }

    public void determineNumber(){

        runExclusions();
        System.out.println(men.get(0).getNumber());

    }

    private void generateList(){

        for(int i = 0; i < N; i++){

            men.add(new Man(i + 1));

        }

    }

    private void runExclusions(){

        int startPosition = numberOfTheFirst;
        int excludeNumber;

        while(men.size() > 1){

            excludeNumber = startPosition + M;

            System.out.println("exclude number:" + excludeNumber + " Size:" + men.size());
            if(excludeNumber > men.size()) excludeNumber = correctExcludeNumber(excludeNumber);
            if(excludeNumber == 0) excludeNumber = men.size() - 1;

            men.remove(excludeNumber - 1);

            startPosition = excludeNumber;

        }

    }

    private int correctExcludeNumber(int excludeNumber){

        if(M < men.size()) return excludeNumber -= men.size();
        return excludeNumber%=men.size();

    }


    class Man{

        int number;

        Man(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

    }

}
