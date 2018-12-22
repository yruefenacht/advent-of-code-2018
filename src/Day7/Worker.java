package Day7;

class Worker {

    int testCounter = 0;
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
            testCounter++;
            currentWork--;
            if(currentWork == 0) this.state = WorkerState.FINISHED;
        }
    }

    String getLetter() {
        return this.letter;
    }

    WorkerState getState() {
        return this.state;
    }

    void reset() {
        testCounter = 0;
        this.currentWork = 0;
        this.letter = "";
        this.state = WorkerState.READY;
    }

}
