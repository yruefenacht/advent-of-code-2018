package Day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Checksum {


    public int checksum() throws FileNotFoundException {

        int two = 0;
        int three = 0;

        Scanner scanner = new Scanner(new FileReader("src/Day2/input.txt"));

        while(scanner.hasNext()) {

            int hasTwo = 0, hasThree = 0;
            String line = scanner.nextLine();

            char[] chars = line.toCharArray();

            for(char c : chars) {
                if(contains(chars, c) == 2) hasTwo = 1;
                if(contains(chars, c) == 3) hasThree = 1;
            }

            two += hasTwo;
            three += hasThree;

        }

        return two * three;

    }

    private int contains(char[] chars, char c) {

        int counter = 0;
        for(char i : chars)
            if(i == c) counter++;

        return counter;
    }


    public String getBoxId() throws FileNotFoundException {

        ArrayList<String> list = getList();
        String b1 = "";
        String b2 = "";

        for(String s : list) {
            for(String i : list) {
                if(differsBy(s, i) == 1) {
                    b1 = s; b2 = i;
                    break;
                }
            }
        }



        StringBuilder stringBuilder = new StringBuilder(b1);
        stringBuilder.deleteCharAt(getDifferIndex(b1, b2));
        return stringBuilder.toString();
    }

    private int getDifferIndex(String b1, String b2) {
        for(int i = 0; i < b1.length(); i++) {
            if(b1.charAt(i) != b2.charAt(i)) return i;
        }
        return 0;
    }

    private int differsBy(String a, String b) {

        int counter = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) counter++;
        }
        return counter;
    }

    private ArrayList<String> getList() throws FileNotFoundException{

        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/Day2/input.txt"));

        while(scanner.hasNext()) {

            String id = scanner.nextLine();
            list.add(id);
        }

        return list;
    }
}
