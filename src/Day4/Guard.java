package Day4;

public class Guard {

    private int id;
    private int currentSleep = 0;
    private int[] minutes = new int[60];

    int getId() {
        return this.id;
    }

    void setId(int id) {
        this.id = id;
    }

    void sleep(int min) {
        this.currentSleep = min;
    }

    void wakeup(int min) {

        for(int i = this.currentSleep; i < min; i++) {
            minutes[i]++;
        }
    }

    int getSleep() {

        int sleep = 0;
        for(int i : minutes) sleep += i;
        return sleep;
    }


    int getMinute() {
        int max = 0, maxIndex = 0;
        for(int i = 0; i < this.minutes.length; i++) {
            if(minutes[i] > max) {
                max = minutes[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }



    public int getMaxIndex() {

        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < this.minutes.length; i++) {
            if(minutes[i] > max) {
                max = minutes[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    int[] getMInutes() {return this.minutes;}
}
