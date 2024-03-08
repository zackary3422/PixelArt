package com.example.pixelpaintprogram;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


//DEFAULT PROVIDED CLASS
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}