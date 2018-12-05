package Day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Areas {

    private final int dim = 1100;

    public int overlaps() throws FileNotFoundException {

        int overlaps = 0;

        int[][] field = new int[dim][dim];

        Scanner scanner = new Scanner(new FileReader("src/Day3/areas"));

        while(scanner.hasNext()) {

            String line = scanner.nextLine();
            ArrayList<int[]> currentCoords = getCoords(line);

            for(int[] coords : currentCoords)
                field[coords[0]][coords[1]]++;

        }

        for(int x = 0;  x < dim; x++) {
            for(int y = 0; y < dim; y++) {
                if(field[x][y] >= 2) overlaps++;
            }
        }

        return overlaps;
    }

    private ArrayList<int[]> getCoords(String line) {

        ArrayList<int[]> coords = new ArrayList<>();

        int offsetX = 0, offsetY = 0;
        int width = 0, height = 0;

        Pattern pattern = Pattern.compile("\\d{1,3},\\d{1,3}");
        Matcher matcher = pattern.matcher(line);
        if(matcher.find()) {
            String offsets = matcher.group(0);
            offsetX = Integer.parseInt(offsets.split(",")[0]);
            offsetY = Integer.parseInt(offsets.split(",")[1]);
        }

        pattern = Pattern.compile("\\d{1,2}x\\d{1,2}");
        matcher = pattern.matcher(line);
        if(matcher.find()) {
            String offsets = matcher.group(0);
            width = Integer.parseInt(offsets.split("x")[0]);
            height = Integer.parseInt(offsets.split("x")[1]);
        }

        for(int x = offsetX; x < offsetX + width; x++) {
            for(int y = offsetY; y < offsetY + height; y++) {
                coords.add(new int[]{x, y});
            }
        }

        return coords;
    }


    public int getSingleId() throws FileNotFoundException {

        int[][] field = new int[dim][dim];

        Scanner scanner = new Scanner(new FileReader("src/Day3/areas"));
        ArrayList<ArrayList<int[]>> areas = new ArrayList<>();

        while(scanner.hasNext()) {

            String line = scanner.nextLine();
            ArrayList<int[]> currentCoords = getCoords(line);
            areas.add(currentCoords);

            for(int[] coords : currentCoords)
                field[coords[0]][coords[1]]++;

        }

        int counter = 0;
        int id = 0;
        for(ArrayList<int[]> area : areas) {
            counter++;
            boolean isUnique = true;
            for(int[] c : area)
                if(field[c[0]][c[1]] >= 2) isUnique = false;
            if(isUnique) {
                id = counter;
                break;
            }
        }

        return counter;

    }
}
