package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));

        // create a scalable content pane
        ScalableContentPane scaledPane = new ScalableContentPane();

        // use it's predefined content pane as root pane
        Pane root = scaledPane.getContentPane();

        // add rectangles and make them draggable
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

        // setup the stage
        primaryStage.setTitle("TableManager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
