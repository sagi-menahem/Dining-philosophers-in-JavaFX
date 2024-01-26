package com.sagiia.maman15ex2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * The Main class serves as the entry point for the JavaFX application.
 * It initializes the JavaFX stage, loads the FXML file for the user interface, and sets up the application scene.
 */
public class Main extends Application {

    /**
     * The start method is called when the JavaFX application is launched.
     * It sets up the stage, loads the FXML file, and displays the application scene.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If there is an error loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Create a FXMLLoader to load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("maman15ex2-view.fxml"));

        // Create a scene with the loaded FXML file content
        Scene scene = new Scene(fxmlLoader.load(), 780, 300);

        // Set the stage title
        stage.setTitle("Sagi Menahem - Maman 15 Ex 2");

        // Set the scene for the stage
        stage.setScene(scene);

        // Show the stage
        stage.show();

        // Set an event handler for the close request of the JavaFX Stage
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            // This method is called when the close request is received
            @Override
            public void handle(WindowEvent t) {
                // Platform.exit() initiates the JavaFX platform shutdown process
                Platform.exit();

                // System.exit(0) forcefully terminates the Java Virtual Machine (JVM)
                System.exit(0);
            }
        });
    }

    /**
     * The main method is the entry point for the application.
     * It launches the JavaFX application by calling the launch method.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch();
    }
}