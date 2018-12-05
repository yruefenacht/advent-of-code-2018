package Day4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Guards {


    private ArrayList<String> getGuardList() throws FileNotFoundException {

        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/Day4/guards"));
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            list.add(line);
        }

        Collections.sort(list);

        return list;
    }

    private ArrayList<Guard> getGuards() throws FileNotFoundException {

        ArrayList<String> guardList = getGuardList();
        ArrayList<Guard> guards = new ArrayList<>();

        Guard currentGuard = null;

        for(String guard : guardList) {

            if(containsHastag(guard.toCharArray())) {


                int id = 0;
                Pattern pattern = Pattern.compile("#\\d{1,4}");
                Matcher matcher = pattern.matcher(guard);
                if(matcher.find()) {
                    String id_s = matcher.group(0);
                    id = Integer.parseInt(id_s.replace("#", ""));
                }

                currentGuard = getGuardById(guards,id);

                if(currentGuard == null) {
                    currentGuard = new Guard();
                    guards.add(currentGuard);
                    currentGuard.setId(id);
                }

            }

            int hour = 0, min = 0;
            Pattern pattern = Pattern.compile("\\d{2}:\\d{2}");
            Matcher matcher = pattern.matcher(guard);
            if(matcher.find()) {
                String offsets = matcher.group(0);
                hour = Integer.parseInt(offsets.split(":")[0]);
                min = Integer.parseInt(offsets.split(":")[1]);
            }

            if(guard.contains("falls")) currentGuard.sleep(min);
            if(guard.contains("wakes")) currentGuard.wakeup(min);


        }

        return guards;
    }

    public int getGuardMinute() throws FileNotFoundException {

        ArrayList<Guard> guards = getGuards();

        Guard maxGuard = null;
        int maxSleep = 0;
        for(Guard g : guards){
            if(g.getSleep() > maxSleep) {
                maxSleep = g.getSleep();
                maxGuard = g;
            }
        }

        int maxId = maxGuard.getId();
        int maxMinute = maxGuard.getMinute();

        return maxId * maxMinute;
    }


    public int getMostFrequentGuard() throws FileNotFoundException {

        ArrayList<Guard> guards = getGuards();

        int totalMaxIndex = 0;
        int maxValue = 0;

        Guard maxGuard = null;

        for(Guard guard : guards) {

            int maxIndex = guard.getMaxIndex();
            if(guard.getMInutes()[maxIndex] > maxValue) {
                maxValue = guard.getMInutes()[maxIndex];
                totalMaxIndex = maxIndex;
                maxGuard = guard;
            }
        }

        return totalMaxIndex * maxGuard.getId();
    }


    private Guard getGuardById(ArrayList<Guard> guards, int id) {
        for(Guard g : guards)
            if(g.getId() == id) return g;
        return null;
    }

    private boolean containsHastag(char[] chars) {
        for(char c : chars)
            if(c == '#') return true;
        return false;
    }

}
