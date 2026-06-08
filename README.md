
# Astro Rover Simulation 🪐

A 2D, event-driven graphical simulation built in Java using the JavaFX framework. This project demonstrates core Object-Oriented Programming principles and strict adherence to the Model-View-Controller (MVC) architectural pattern to manage state, render graphics, and handle user input.

## Features

* **Event-Driven Movement:** Listens for native keyboard events (Arrow keys) to update the rover's orientation and position in real-time.
* **Strict MVC Architecture:** * **Model:** Pure Java classes (`Rover`, `Environment`, `Direction`) encapsulate the state, coordinate system, and grid boundaries completely independent of the UI.
    * **View:** JavaFX `GridPane` and `Rectangle` shapes handle the visual rendering of the environment.
    * **Controller:** Intercepts keyboard events, validates movement logic against the environment's state, and commands the View to re-render.
* **Collision Detection:** The controller preemptively validates target coordinates, blocking movement if the rover attempts to drive off the grid boundaries or into a predefined obstacle.
* **Defensive Programming:** Implements Enums for directional logic and access modifiers for state encapsulation.

## Tech Stack

* **Language:** Java 17
* **Graphics Framework:** JavaFX
* **Build Tool:** Maven

## Installation & Execution

This application is configured to build and run seamlessly using Maven.

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/yourusername/rover-gui.git](https://github.com/yourusername/rover-gui.git)
   cd rover-gui

2. **Run the application:**
Ensure you have Maven installed, then execute the JavaFX plugin from your terminal:

    ```bash
    mvn clean javafx:run

**Controls**

* **Left Arrow:** Rotate rover 90 degrees counter-clockwise.

* **Right Arrow:** Rotate rover 90 degrees clockwise.

* **Up Arrow:** Move forward one grid space in the current facing direction.