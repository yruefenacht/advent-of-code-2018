package Day7;

class Worker {

    private int currentWork = 0;
    private String letter = "";
    private WorkerState state = WorkerState.READY;

    void setWork(String letter, int min) {

        this.currentWork = min;
        this.letter = letter;
        this.state = WorkerState.WORKING;
    }

    void work() {

        if(this.state == WorkerState.WORKING) {
            currentWork--;
            if(currentWork == 0) {
                this.state = WorkerState.FINISHED;
            }
        }
    }

    String getLetter() {
        return this.letter;
    }

    void reset() {
        this.currentWork = 0;
        this.state = WorkerState.READY;
    }

}
