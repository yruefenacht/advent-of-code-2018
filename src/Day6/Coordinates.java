package Day6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Coordinates {

    private final int dim = 400;
    private int[][] grid = new int[dim][dim];

    public int getLargestArea() throws FileNotFoundException {

        ArrayList<int[]> coordinates = getCoordinates();

        int coutner = 1;
        for(int[] coordinate : coordinates) {
            grid[coordinate[0]][coordinate[1]] = coutner;
            coutner++;
        }

        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++) {
                int[] nearestPoint = getNearestPoint(i, j);
                grid[i][j] = grid[nearestPoint[0]][nearestPoint[1]];
            }
        }

        return 0;
    }

    private int[] getNearestPoint(int x, int y) {

        return new int[]{x, y};
    }


    private int getDistance(int[] p1, int[] p2) {
        return 0;
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
}
