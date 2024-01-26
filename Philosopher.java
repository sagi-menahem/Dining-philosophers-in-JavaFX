package com.sagiia.maman15ex2;

import java.util.Random;

/**
 * The Philosopher class represents a philosopher in a dining philosophers problem.
 * Each philosopher has two chopsticks and alternates between eating and thinking.
 * It extends the Thread class to run as a separate thread.
 */
public class Philosopher extends Thread{

    // Maximum time spent eating in milliseconds
    private static final int MAX_EATING_TIME = 1500;

    // Maximum time spent thinking in milliseconds
    private static final int MAX_THINKING_TIME = 2000;

    // Column index of the image representing this philosopher in the grid pane
    private final int colImage;

    // Random object for generating random sleep times
    private final Random rnd;

    // References to the philosopher's two chopsticks
    private final Chopstick firstStick;
    private final Chopstick secondStick;

    // Reference to the controller for updating the GUI
    Maman15Ex2Controller controller;

    /**
     * Constructor to initialize the Philosopher instance with the required parameters.
     *
     * @param controller  The controller managing the visualization of philosophers and chopsticks.
     * @param firstStick  The first chopstick used by the philosopher.
     * @param secondStick The second chopstick used by the philosopher.
     * @param colImage    The column index of the image representing this philosopher in the grid pane.
     */
    public Philosopher(Maman15Ex2Controller controller, Chopstick firstStick, Chopstick secondStick, int colImage) {
        this.firstStick = firstStick;
        this.secondStick = secondStick;
        rnd = new Random();
        this.controller = controller;
        this.colImage = colImage;
    }

    /**
     * The main run method of the thread. The philosopher alternates between eating and thinking in an infinite loop.
     */
    @Override
    public void run() {

        while (true) {
            // Acquire the first chopstick
            firstStick.getStick(true);

            // Try to acquire the second chopstick; if not available, release the first chopstick and continue
            if(!secondStick.getStick(false)){
                firstStick.returnStick();
                continue;
            }

            // Update the GUI to reflect that the chopsticks are in use
            controller.setChopstickVisible(firstStick.getColImage(), false);
            controller.setChopstickVisible(secondStick.getColImage(), false);
            controller.setPhilosopherEating(colImage);

            // Simulate eating time
            wasteTime(MAX_EATING_TIME);

            // Release both chopsticks and update the GUI accordingly
            firstStick.returnStick();
            secondStick.returnStick();
            controller.setChopstickVisible(firstStick.getColImage(), true);
            controller.setChopstickVisible(secondStick.getColImage(), true);
            controller.setPhilosopherThinking(colImage);

            // Simulate thinking time
            wasteTime(MAX_THINKING_TIME);
            controller.setPhilosopherThinkingAboutEat(colImage);
        }
    }

    /**
     * Helper method to simulate the passage of time by causing the thread to sleep for a random duration.
     *
     * @param limit The upper limit for the sleep time in milliseconds.
     */
    private void wasteTime(int limit){
        try {
            sleep(rnd.nextInt(limit));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
