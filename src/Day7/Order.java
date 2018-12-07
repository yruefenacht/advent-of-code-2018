package Day7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {


    private ArrayList<Letter> letters = new ArrayList<>();

    public String getOrder() throws FileNotFoundException {


        Scanner scanner = new Scanner(new FileReader("src/Day7/orders"));
        while(scanner.hasNext()) {

            String line = scanner.nextLine();

            String letter = "";
            String preConLetter = "";
            Pattern pattern = Pattern.compile(" [A-Z] ");
            Matcher matcher = pattern.matcher(line);
            int counter = 0;
            while(matcher.find()) {
                if(counter == 0) preConLetter = matcher.group().replace(" ", "");
                if(counter == 1) letter = matcher.group().replace(" ", "");
                counter++;
            }

            Letter l = getLetterByName(letter);
            Letter preCon = getLetterByName(preConLetter);

            if(preCon == null) {
                preCon = new Letter(preConLetter);
                letters.add(preCon);
            }

            if(l == null) {
                l = new Letter(letter);
                letters.add(l);
            }
            l.addPreConLetter(preCon);

        }

        String finalOrder = "";

        ArrayList<Letter> setLetters = new ArrayList<>();
        ArrayList<Letter> availableLetters = getAvailableLetters(setLetters);

        for(int i = 0; i < 26; i++) {

            availableLetters = getAvailableLetters(setLetters);
            String currentLetter = getFirstAlphLetter(availableLetters);
            finalOrder += currentLetter;
            setLetters.add(getLetterByName(currentLetter));
        }

        return finalOrder;
    }


    private String getFirstAlphLetter(ArrayList<Letter> letters) {

        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int firstIndex = 25;
        char firstLetter = 'Z';
        for(Letter l : letters) {
            if (abc.indexOf(l.getName()) < firstIndex) {
                firstIndex = abc.indexOf(l.getName());
                firstLetter = abc.charAt(firstIndex);
            }
        }

        return Character.toString(firstLetter);
    }

    private ArrayList<Letter> getAvailableLetters(ArrayList<Letter> setLetters) {

        ArrayList<Letter> availableLetters = new ArrayList<>();
        for(Letter l : letters) {

            boolean containsPreCons = true;
            for(Letter preConLetter : l.getPreConLetters())
                if(! containsLetter(setLetters, preConLetter)) containsPreCons = false;

            if(containsPreCons && ! containsLetter(setLetters, l)) availableLetters.add(l);
        }
        return availableLetters;
    }

    private Letter getLetterByName(String letter) {
        for(Letter l : letters)
            if(l.getName().equals(letter)) return l;
        return null;
    }

    private boolean containsLetter(ArrayList<Letter> letters, Letter l) {

        for(Letter letter : letters)
            if(letter.getName().equals(l.getName())) return true;
        return false;
    }
}
