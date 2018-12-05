package Day5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Polymers {


    private String getReaction(String str) {

        int currentIndex = 1;

        while(currentIndex < str.length()) {

            char firstChar  = str.charAt(currentIndex-1);
            char secondChar = str.charAt(currentIndex);

            if(areAttracted(firstChar, secondChar)) {
                str = removeGapAt(str, currentIndex - 1);
                if(currentIndex > 1) currentIndex--;
            } else {
                currentIndex++;
            }

        }

        return str;
    }


    public int getUnits() throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader("src/Day5/string"));

        String polymer = scanner.nextLine();

        return getReaction(polymer).length();
    }


    public int getShortestPolymer() throws FileNotFoundException {

        String alph = "abcdefghijklmnopqrstuvwxyz";
        Scanner scanner = new Scanner(new FileReader("src/Day5/string"));
        String polymer = scanner.nextLine();

        int shortest = getReaction(polymer).length();

        for(char c : alph.toCharArray()) {

            String polymerWithChar = polymer.replaceAll(c + "|" + Character.toUpperCase(c), "");
            String currentPolymer = getReaction(polymerWithChar);

            if(currentPolymer.length() < shortest) shortest = currentPolymer.length();

        }

        return shortest;
    }


    private boolean areAttracted(char a, char b) {
        if(Character.toLowerCase(a) == Character.toLowerCase(b)) {
            if (Character.isLowerCase(a) && Character.isUpperCase(b) ||
                Character.isUpperCase(a) && Character.isLowerCase(b)) {
                return true;
            }
        }
        return false;
    }


    private String removeGapAt(String str, int index) {
        return str.substring(0, index) + str.substring(index + 2);
    }

}
