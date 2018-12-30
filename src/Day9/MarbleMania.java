package Day9;

import java.util.ArrayList;
import java.util.Collections;

public class MarbleMania {


    private int players, marbles;


    public MarbleMania(int players, int marbles) {

        this.players = players;
        this.marbles = marbles;
    }


    public int getMaxScore() {

        ArrayList<Integer> deque = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();

        for(int i = 0; i < this.players; i++)
            scores.add(0);

        deque.add(0);

        for(int i = 1; i <= this.marbles; i++) {

            int player = i % this.players;

            if(i % 23 == 0) {

                Collections.rotate(deque, 7);
                scores.set(player, scores.get(player) + i + deque.get(deque.size() - 1));
                deque.remove(deque.size() - 1);
                Collections.rotate(deque, -1);

            } else {

                Collections.rotate(deque, -1);
                deque.add(i);
            }

        }

        return Collections.max(scores);
    }

}
