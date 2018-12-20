package Day7;

class Worker {

    private boolean working = false;
    private Letter workingOn = null;

    public boolean isWorking() {
        return working;
    }

    void setWorking(boolean working) {
        this.working = working;
    }

    public Letter getWorkingOn() {
        return workingOn;
    }

    void setCurrentWork(Letter workingOn) {
        this.workingOn = workingOn;
    }

}
