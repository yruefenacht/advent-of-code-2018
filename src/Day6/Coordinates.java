package Day6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Coordinates {

    private final int dim = 400;
    private int[][] grid = new int[dim][dim];
    private ArrayList<int[]> coordinates;

    public int getLargestArea() throws FileNotFoundException {

        HashMap<Integer, Integer> coordinateCounts = new HashMap();
        coordinates = getCoordinates();

        int counter = 1;
        for(int[] coordinate : coordinates) {
            grid[coordinate[0]][coordinate[1]] = counter;
            coordinateCounts.put(counter, 1);
            counter++;
        }

        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++) {

                if(grid[j][i] == 0) {
                    int nearestValue = getNearestValue(j, i);
                    grid[j][i] = nearestValue;
                    if(nearestValue != 0) {
                        int value = coordinateCounts.get(nearestValue) + 1;
                        coordinateCounts.put(nearestValue, value);
                    }
                }
            }
        }


        int maxCoordinate = 0;
        for(Map.Entry<Integer, Integer> o : coordinateCounts.entrySet()) {

            if(!isOnEdge(o.getKey()) && o.getValue() > maxCoordinate) {
                maxCoordinate = o.getValue();
            }

        }


        return maxCoordinate;
    }

    private boolean isOnEdge(int value) {

        for(int i = 0; i < dim; i++) {
            if(grid[i][0] == value || grid[0][i] == value || grid[dim-1][i] == value || grid[i][dim-1] == value)
                return true;
        }
        return false;
    }


    private int getNearestValue(int x, int y) {

        int[] nearestPoint = new int[]{};
        int shortestDistance = dim + dim;
        ArrayList<Integer> distances = new ArrayList<>();

        for(int[] coordinate : coordinates) {

            int distance = getDistance(new int[]{x,y}, coordinate);
            distances.add(distance);

            if(distance < shortestDistance) {
                shortestDistance = distance;
                nearestPoint = coordinate;
            }
        }

        if(Collections.frequency(distances, shortestDistance) > 1) return 0;

        return grid[nearestPoint[0]][nearestPoint[1]];
    }


    private int getDistance(int[] p1, int[] p2) {

        int x = Math.abs(p1[0] - p2[0]);
        int y = Math.abs(p1[1] - p2[1]);

        return x+y;
    }

    private ArrayList<int[]> getCoordinates() throws FileNotFoundException {

        ArrayList<int[]> coordinates = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/Day6/coordinates"));
        while(scanner.hasNext()) {
            String line = scanner.nextLine().replace(" ", "");
            int x = Integer.parseInt(line.split(",")[0]);
            int y = Integer.parseInt(line.split(",")[1]);
            coordinates.add(new int[]{x,y});
        }

        return coordinates;
    }


    private final int regionMessure = 10000;

    public int getRegion() throws FileNotFoundException {

        grid = new int[dim][dim];

        int counter = 0;

        coordinates = getCoordinates();

        for(int[] coordinate : coordinates) {
            grid[coordinate[0]][coordinate[1]] = 1;
        }

        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++) {
                if(getTotalDistance(i, j) < regionMessure) counter++;
            }
        }

        return counter;
    }

    private int getTotalDistance(int x, int y) {

        int sum = 0;

        for(int[] coordinate : coordinates) {
            sum += getDistance(new int[]{x,y}, coordinate);
        }
        return sum;
    }
}
