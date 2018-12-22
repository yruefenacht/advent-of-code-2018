package Day7;

import java.util.ArrayList;

class Letter {

    private String name;
    private ArrayList<Letter> preConLetters;

    Letter(String name) {
        this.name = name;
        this.preConLetters = new ArrayList<>();
    }

    void addPreConLetter(Letter letter) {
        this.preConLetters.add(letter);
    }

    ArrayList<Letter> getPreConLetters() {
        return this.preConLetters;
    }



    String getName() {return this.name;}
}