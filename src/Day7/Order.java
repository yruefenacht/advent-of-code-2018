package Day7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {


    private ArrayList<Letter> letters = new ArrayList<>();
    String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Order() throws FileNotFoundException {

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
    }

    public String getOrder() {

        String finalOrder = "";

        ArrayList<Letter> setLetters = new ArrayList<>();
        ArrayList<Letter> availableLetters = getAvailableLetters(setLetters);

        while(! availableLetters.isEmpty()) {

            availableLetters = getAvailableLetters(setLetters);
            String currentLetter = getFirstAlphLetter(availableLetters);
            finalOrder += currentLetter;
            setLetters.add(getLetterByName(currentLetter));
        }

        return finalOrder;
    }


    private String getFirstAlphLetter(ArrayList<Letter> letters) {


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


    public int countDuration() {

        ArrayList<Worker> workers = new ArrayList<>();
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        Worker worker3 = new Worker();
        Worker worker4 = new Worker();
        Worker worker5 = new Worker();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(worker4);
        workers.add(worker5);

        ArrayList<Letter> setLetters = new ArrayList<>();
        ArrayList<Letter> availableLetters = getAvailableLetters(setLetters);

        //int max = 1911;
        int counter = -2;

        while(! availableLetters.isEmpty()) {

            availableLetters = getAvailableLetters(setLetters);

            Collections.sort(availableLetters, Comparator.comparing(Letter::getName));

            for(Worker w : workers) w.work();

            for(Letter letter : availableLetters) {

                for(Worker worker : workers) {

                    if(worker.getState() == WorkerState.FINISHED) {

                        setLetters.add(getLetterByName(worker.getLetter()));
                        worker.reset();

                    }else if(worker.getState() == WorkerState.READY) {

                        if(! isWorkedOn(workers, letter.getName()) && ! containsLetter(setLetters, letter))
                            worker.setWork(letter.getName(), 61 + abc.indexOf(letter.getName()));

                    }

                }
            }

            if(isBeingWorked(workers)) counter++;
        }

        return counter;
    }

    private boolean isBeingWorked(ArrayList<Worker> workers) {
        for(Worker w : workers)
            if(w.getState() == WorkerState.WORKING) return true;
        return false;
    }

    private boolean isWorkedOn(ArrayList<Worker> workers, String letter) {
        for(Worker worker : workers)
            if(worker.getLetter().equals(letter)) return true;
        return false;
    }

}
