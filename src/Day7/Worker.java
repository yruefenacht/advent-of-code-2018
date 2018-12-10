package Day7;

public class Worker {

    private int currentWork = 0;
    private String letter = "";

    public void setWork(String letter, int min) {
        this.currentWork = min;
        this.letter = letter;
    }

    public void work() {
        if(this.isBusy())
            this.currentWork--;
    }

    public boolean isBusy() {
        return this.currentWork > 0;
    }

    public String getLetter() {
        return this.letter;
    }
}
