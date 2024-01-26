package com.sagiia.maman15ex2;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.Objects;

/**
 * The Maman15Ex2Controller class is the controller for the JavaFX application.
 * It manages the visualization of philosophers, chopsticks, and their actions in a dining philosophers problem.
 */
public class Maman15Ex2Controller {

    // GUI Components
    @FXML
    private GridPane gridPane;

    // Array to hold ImageView objects for images of philosophers, forks, and plates
    private ImageView[][] images;

    // Array to hold Chopstick objects representing the chopsticks used by philosophers
    private Chopstick[] chopsticks;

    /**
     * Initializes the controller. This method is automatically called after the FXML file is loaded.
     * It sets up the initial images, adds them to the grid, and initializes philosophers and chopsticks.
     */
    @FXML
    private void initialize() {
        setImages();
        addImages();
        setChopsticks();
        setPhilosophers();
    }

    /**
     * Initializes the array of ImageView objects with images for philosophers, forks, and plates.
     */
    private void setImages() {
        images = new ImageView[11][2];

        images[0][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("fork.jpg"))));
        images[0][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("background_plate.jpg"))));
        images[1][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("thinking_about_eat.jpg"))));
        images[1][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("plate.jpg"))));
        images[2][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("fork.jpg"))));
        images[2][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("background_plate.jpg"))));
        images[3][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("thinking_about_eat.jpg"))));
        images[3][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("plate.jpg"))));
        images[4][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("fork.jpg"))));
        images[4][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("background_plate.jpg"))));
        images[5][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("thinking_about_eat.jpg"))));
        images[5][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("plate.jpg"))));
        images[6][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("fork.jpg"))));
        images[6][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("background_plate.jpg"))));
        images[7][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("thinking_about_eat.jpg"))));
        images[7][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("plate.jpg"))));
        images[8][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("fork.jpg"))));
        images[8][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("background_plate.jpg"))));
        images[9][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("thinking_about_eat.jpg"))));
        images[9][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("plate.jpg"))));
        images[10][0] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("fork.jpg"))));
        images[10][1] = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("background_plate.jpg"))));
    }

    /**
     * Adds the initialized images to the grid pane for display.
     */
    private void addImages() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 2; j++) {
                gridPane.add(images[i][j], i, j);
            }
        }
    }

    /**
     * Initializes the array of Chopstick objects representing the chopsticks used by philosophers.
     */
    private void setChopsticks() {
        chopsticks = new Chopstick[5];
            chopsticks[0] = new Chopstick(0);
            chopsticks[1] = new Chopstick(2);
            chopsticks[2] = new Chopstick(4);
            chopsticks[3] = new Chopstick(6);
            chopsticks[4] = new Chopstick(8);

    }

    /**
     * Initializes the array of Philosopher objects, sets up their relationships with chopsticks,
     * and starts them as threads.
     */
    private void setPhilosophers() {
        Philosopher[] philosophers = new Philosopher[5];
        philosophers[0] = new Philosopher(this, chopsticks[0], chopsticks[1], 1);
        philosophers[1] = new Philosopher(this, chopsticks[1], chopsticks[2], 3);
        philosophers[2] = new Philosopher(this, chopsticks[2], chopsticks[3], 5);
        philosophers[3] = new Philosopher(this, chopsticks[3], chopsticks[4], 7);
        philosophers[4] = new Philosopher(this, chopsticks[4], chopsticks[0], 9);
        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    /**
     * Sets the visibility of the chopstick image at the specified column in the grid pane.
     *
     * @param colImage The column index of the image in the grid pane.
     * @param visible  True if the chopstick should be visible, false otherwise.
     */
    public void setChopstickVisible(int colImage, boolean visible) {
        if (visible) {
            images[colImage][0].setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("fork.jpg"))));
            if (colImage == 0) {
                images[10][0].setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("fork.jpg"))));
            }
        } else {
            images[colImage][0].setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("no_fork.jpg"))));
            if (colImage == 0) {
                images[10][0].setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("no_fork.jpg"))));
            }
        }
    }

    /**
     * Sets the image of the philosopher in the specified column to indicate eating.
     *
     * @param colImage The column index of the image in the grid pane.
     */
    public void setPhilosopherEating(int colImage) {
        images[colImage][0].setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("eating.jpg"))));
    }

    /**
     * Sets the image of the philosopher in the specified column to indicate thinking.
     *
     * @param colImage The column index of the image in the grid pane.
     */
    public void setPhilosopherThinking(int colImage) {
        images[colImage][0].setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("thinking.jpg"))));
    }

    /**
     * Sets the image of the philosopher in the specified column to indicate thinking after eating.
     *
     * @param colImage The column index of the image in the grid pane.
     */
    public void setPhilosopherThinkingAboutEat(int colImage) {
        images[colImage][0].setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("thinking_about_eat.jpg"))));
    }
}
