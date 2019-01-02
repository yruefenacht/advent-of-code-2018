package Day10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Stars extends Application {


    ArrayList<Star> stars = new ArrayList<>();
    Button moveButton;
    int counter = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane starPane = new Pane();

        Scanner scanner = new Scanner(new FileReader("src/Day10/input.txt"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int x = Integer.parseInt(line.substring(10, 16).replaceAll(" ", ""));
            int y = Integer.parseInt(line.substring(18, 24).replaceAll(" ", ""));
            int vx = Integer.parseInt(line.substring(36, 38).replaceAll(" ", ""));
            int vy = Integer.parseInt(line.substring(40, 42).replaceAll(" ", ""));

            Star s = new Star(x, y, vx, vy);
            starPane.getChildren().add(s);
            stars.add(s);
        }

        moveButton = new Button("Move");
        moveButton.setOnAction(e -> moveStars());

        BorderPane root = new BorderPane();
        root.setCenter(starPane);
        root.setBottom(moveButton);
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();

        for(int i = 0; i < 10590; i++) moveStars();

    }

    private void moveStars() {

        for(Star s : stars)
            s.move();
        counter++;
        moveButton.setText("Move " + counter);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
