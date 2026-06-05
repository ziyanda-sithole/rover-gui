package com.portfolio.simulation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.portfolio.simulation.model.Direction;
import com.portfolio.simulation.model.Environment;
import com.portfolio.simulation.model.Rover;
import com.portfolio.simulation.view.SimulationView;
import com.portfolio.simulation.controller.SimulationController; // <-- New import

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Initialize the Model
        Environment env = new Environment(10, 10);
        Rover rover = new Rover(0, 0, Direction.SOUTH);

        // 2. Initialize the View
        SimulationView view = new SimulationView(env, rover);

        // 3. Initialize the Controller (The Bridge) <-- NEW
        SimulationController controller = new SimulationController(env, rover, view);

        // 4. Set up the JavaFX Window
        Scene scene = new Scene(view, 400, 400);

        // 5. Attach the keyboard listener to the scene <-- NEW
        scene.setOnKeyPressed(event -> controller.handleKeyPress(event));

        stage.setTitle("Astro Rover Simulation");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Ensure the window can receive keyboard inputs immediately
        view.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}