package Day7;

import java.util.ArrayList;

class Letter {

    private String name;
    private ArrayList<Letter> preConLetters;
    private Worker worker;
    boolean isFinished = false;
    boolean working = false;
    int duration = 0;

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

    boolean isFinished() { return this.isFinished; }

    boolean isWorking() { return this.working; }

    String work() {
        if(! this.working) return "";
        this.duration--;
        if(duration == 0) {
            this.working = false;
            this.isFinished = true;
            this.worker.setWorking(false);
            this.worker.setCurrentWork(null);
            return this.name;
        }
        return "";
    }

    void setWorker(int duration, Worker worker) {
        this.worker = worker;
        this.duration = duration;
        worker.setWorking(true);
        worker.setCurrentWork(this);
        this.working = false;
    }

    boolean preConLettersAreFinished() {
        for(Letter l : this.preConLetters)
            if(! l.isFinished()) return false;
        return true;
    }
}
