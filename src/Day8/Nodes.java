package Day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Nodes {

    private ArrayList<Integer> getList() throws FileNotFoundException {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/Day8/"));

        while(scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        return list;
    }


    int getMetaDataSum() throws FileNotFoundException {

        ArrayList<Integer> nums = this.getList();

        int indexIsNode = 0;




        return 0;
    }
}

