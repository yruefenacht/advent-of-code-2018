package Day1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FrequencyCounter {

    public int getFrequency() throws IOException {

        int result = 0;

        var list = getList();

        for(int i : list)
            result += i;

        return result;
    }

    public int twiceFrequency() throws IOException {

        int result = 0;
        int finalResult = 0;
        var list = getList();
        var resultList = new ArrayList<Integer>();

        boolean found = false;
        int counter = 0;

        while(! found) {
            for(int i : list) {
                result += i;

                if(resultList.contains(result) && counter != 0) {
                    finalResult = result;
                    found = true;
                    break;
                }

                resultList.add(result);
            }
            counter++;
        }

        return finalResult;
    }

    private ArrayList<Integer> getList() throws IOException{

        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/Day1/frequencies.txt"));
        while(scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        return list;
    }
}
