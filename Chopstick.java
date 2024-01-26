package com.sagiia.maman15ex2;

/**
 * The Chopstick class represents a chopstick used by philosophers in a dining philosophers problem.
 * It keeps track of its availability and provides methods for philosophers to acquire and release the chopstick.
 */
public class Chopstick {

    // Column index of the image representing this chopstick in the grid pane
    int colImage;

    // Flag indicating whether the chopstick is free or in use
    private boolean free;

    /**
     * Constructor to initialize the Chopstick instance with a specified column index.
     *
     * @param colImage The column index of the image representing this chopstick in the grid pane.
     */
    public Chopstick(int colImage) {
        // The chopstick is initially free
        free = true;
        this.colImage = colImage;
    }

    /**
     * Method to acquire the chopstick. If it's the first stick requested by a philosopher,
     * it waits until the chopstick becomes available. If it's the second stick, it checks if
     * the chopstick is free before acquiring it.
     *
     * @param isFirstStick True if it's the first chopstick requested, false otherwise.
     * @return True if the chopstick is acquired, false otherwise.
     */
    public synchronized boolean getStick(boolean isFirstStick) {
        // If it's the first stick, wait until the chopstick becomes available
        if (isFirstStick) {
            while (!free) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Mark the chopstick as in use
            free = false;
            return true;

        } else {
            // If it's the second stick, check if the chopstick is free before acquiring it
            if (!free){
                return false;
            }
            else {
                // Mark the chopstick as in use
                free = false;
                return true;
            }
        }
    }

    /**
     * Method to release the chopstick, making it available for other philosophers.
     */
    public synchronized void returnStick(){
        // Mark the chopstick as free
        free = true;
        // Notify waiting philosophers that the chopstick is available
        notifyAll();
    }

    /**
     * Getter method to retrieve the column index of the image representing this chopstick.
     *
     * @return The column index of the image in the grid pane.
     */
    public int getColImage() {
        return colImage;
    }
}
