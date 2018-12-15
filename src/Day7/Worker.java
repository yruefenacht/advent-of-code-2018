package Day7;

public class Worker {

    private int currentWork = 0;
    private String letter = "";
    private boolean isDone = false;

    public void setWork(String letter, int min) {
        this.currentWork = min;
        this.letter = letter;
        this.isDone = false;
    }

    public void work() {
        if(this.isBusy()) {
            this.currentWork--;
            if(this.currentWork == 0) this.isDone = true;
            System.out.println(letter);
        }
    }

    public boolean isBusy() {
        return this.currentWork > 0;
    }

    public String getLetter() {
        return this.letter;
    }

    public boolean isDone() {
        return this.isDone;
    }
}
