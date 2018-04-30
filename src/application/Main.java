package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import jfxtras.labs.scene.layout.ScalableContentPane;
import jfxtras.labs.util.event.MouseControlUtil;

/**
 *         Notes:
 *
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create a scalable content pane
        ScalableContentPane scaledPane = new ScalableContentPane();

        // use it's predefined content pane as root pane
        Pane root = scaledPane.getContentPane();

        // add placers and make them draggable
        for (double y = 3.5; y < 5.5; y++) {
            for (int x = 2; x < 9; x++) {
                Rectangle rect = new Rectangle(30, 30);
                rect.setLayoutX(x*(rect.getWidth() + 10));
                rect.setLayoutY(y*(rect.getHeight() + 10));
                MouseControlUtil.makeDraggable(rect);
                root.getChildren().add(rect);
            }
        }

        // add the scalable pane to the scene
        Scene scene = new Scene(scaledPane, 1000, 750);

        // connect to CSS for background image
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        root.setId("pane");

        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");

        two.setLayoutX(30);
        three.setLayoutX(60);
        four.setLayoutX(90);
        five.setLayoutX(120);

        root.getChildren().add(one);
        root.getChildren().add(two);
        root.getChildren().add(three);
        root.getChildren().add(four);
        root.getChildren().add(five);

        // Below I process events with an anonymous event handler
        one.setOnAction(
                e -> System.out.println("Table 1 should be free")
        );
        
        two.setOnAction(
                e -> System.out.println("Table 2 should be free")
        );

        three.setOnAction(
                e -> System.out.println("Table 3 should be free")
        );

        four.setOnAction(
                e -> System.out.println("Table 4 should be free")
        );

        five.setOnAction(
                e -> System.out.println("Table 5 should be free")
        );

        // setup the stage
        primaryStage.setTitle("TableManager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
