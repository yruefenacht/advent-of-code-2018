package Day10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Stars {


    public void printStars() throws FileNotFoundException {

        while (true) {

            System.out.println("Enter time: ");
            Scanner input = new Scanner(System.in);
            int time = input.nextInt();

            ArrayList<Star> stars = new ArrayList<>();
            ArrayList<Integer> xList = new ArrayList<>();
            ArrayList<Integer> yList = new ArrayList<>();

            Scanner scanner = new Scanner(new FileReader("src/Day10/input.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                int x = Integer.parseInt(line.substring(10, 16).replaceAll(" ", ""))/1000;
                int y = Integer.parseInt(line.substring(18, 24).replaceAll(" ", ""))/1000;
                int vx = Integer.parseInt(line.substring(36, 38).replaceAll(" ", ""));
                int vy = Integer.parseInt(line.substring(40, 42).replaceAll(" ", ""));

                Star s = new Star(x + (time * vx), y + (time * vy));
                stars.add(s);
                xList.add(x);
                yList.add(y);
            }

            int xMin = Collections.min(xList);
            int xMax = Collections.max(xList) + 1;
            int yMin = Collections.min(yList);
            int yMax = Collections.max(yList) + 1;

            int xDim = xMax - xMin;
            int yDim = yMax - yMin;

            String[][] field = new String[xDim][yDim];
            for (int x = 0; x < xDim; x++)
                for (int y = 0; y < yDim; y++)
                    field[x][y] = " ";

            for (Star s : stars)
                field[s.getY() - yMin][s.getX() - xMin] = "#";

            for (int x = 0; x < xDim; x++) {
                for (int y = 0; y < yDim; y++)
                    System.out.print(field[x][y]);
                System.out.println("");
            }
        }
    }

}
