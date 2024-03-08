package com.example.pixelpaintprogram;

import com.example.pixelpaintprogram.Tools.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {

    //Sliders
    public static Slider redSlider;
    public static Slider blueSlider;
    public static Slider greenSlider;


    @Override
    public void start(Stage stage) throws IOException {

        //Tools
        ColorPicker colorPicker = new ColorPicker();
        Pencil pencil = new Pencil();
        PaintBucket paintBucket = new PaintBucket();
        Eraser eraser = new Eraser();


        //Tool Options Scene------------------------------------------------------------------------------------

        Stage toolOptionsStage = new Stage();
        toolOptionsStage.setTitle("Tool Options");

        //Create Color Icon
        Image colorSelectorIcon = colorPicker.getImage();
        ImageView colorSelectorView = new ImageView(colorSelectorIcon);
        colorSelectorView.setFitHeight(50);
        colorSelectorView.setFitWidth(50);

        Button colorSelectorButton = new Button();
        colorSelectorButton.setGraphic(colorSelectorView);

        // Create sliders for RGB colors

        //Red slider
        redSlider = new Slider(0.0, 1.0, 0.0);
        redSlider.setShowTickLabels(true);
        redSlider.setShowTickMarks(true);
        redSlider.setMajorTickUnit(0.2);
        redSlider.setMinorTickCount(5);
        redSlider.setBlockIncrement(0.1);

        Label sliderLabel = new Label("RED");
        sliderLabel.setLabelFor(redSlider);


        //Green slider
        greenSlider = new Slider(0.0, 1.0, 0.0);
        greenSlider.setShowTickLabels(true);
        greenSlider.setShowTickMarks(true);
        greenSlider.setMajorTickUnit(0.2);
        greenSlider.setMinorTickCount(5);
        greenSlider.setBlockIncrement(0.1);

        Label sliderLabelGreen = new Label("GREEN");
        sliderLabelGreen.setLabelFor(greenSlider);

        //Blue slider
        blueSlider = new Slider(0.0, 1.0, 0.0);
        blueSlider.setShowTickLabels(true);
        blueSlider.setShowTickMarks(true);
        blueSlider.setMajorTickUnit(0.2);
        blueSlider.setMinorTickCount(5);
        blueSlider.setBlockIncrement(0.1);

        Label sliderLabelBlue = new Label("BLUE");
        sliderLabelBlue.setLabelFor(blueSlider);

        //Create Pencil icon
        Image pencilIcon = pencil.getImage();
        ImageView pencilView = new ImageView(pencilIcon);
        pencilView.setFitHeight(50);
        pencilView.setFitWidth(50);

        //Create button
        Button pencilButton = new Button();
        pencilButton.setGraphic(pencilView);

        pencilButton.setOnAction(e -> {//Set event action
            Pencil.selectPencil();
        });

        //Create Pain Bucket Icon
        Image paintIcon = paintBucket.getImage();
        ImageView paintView = new ImageView(paintIcon);
        paintView.setFitHeight(50);
        paintView.setFitWidth(50);

        //Create button
        Button paintButton = new Button();
        paintButton.setGraphic(paintView);

        paintButton.setOnAction(e -> {
            PaintBucket.selectPaintBucket();
        });//Set event action

        //Create Eraser Icon
        Image eraserIcon = eraser.getImage();
        ImageView eraserView = new ImageView(eraserIcon);
        eraserView.setFitHeight(50);
        eraserView.setFitWidth(50);

        //Create button
        Button eraserButton = new Button();
        eraserButton.setGraphic(eraserView);

        eraserButton.setOnAction(e -> {
            Eraser.selectEraser();
        });//Set event action

        //Add forwards and backwards button
        Image reverseIcon = new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\reversebutton.png");
        ImageView reverseView = new ImageView(reverseIcon);
        reverseView.setFitHeight(50);
        reverseView.setFitWidth(50);

        Button reverseButton = new Button();
        reverseButton.setGraphic(reverseView);

        reverseButton.setOnAction(e -> {
            Canvas.backInHistory();
        });


        //Add forwards  button
        Image forwardIcon = new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\reversebutton1.png");
        ImageView forwardView = new ImageView(forwardIcon);
        forwardView.setFitHeight(50);
        forwardView.setFitWidth(50);

        Button forwardButton = new Button();
        forwardButton.setGraphic(forwardView);

        forwardButton.setOnAction(e -> {
            Canvas.forwardInHistory();
        });


        //Add tools to pane with VBox
        VBox toolOptionsRoot = new VBox(10);
        toolOptionsRoot.getChildren().add(colorSelectorView);
        toolOptionsRoot.getChildren().addAll(sliderLabel, redSlider, sliderLabelGreen, greenSlider, sliderLabelBlue, blueSlider);
        toolOptionsRoot.getChildren().add(pencilButton);
        toolOptionsRoot.getChildren().add(paintButton);
        toolOptionsRoot.getChildren().add(eraserButton);
        toolOptionsRoot.getChildren().add(reverseButton);
        toolOptionsRoot.getChildren().add(forwardButton);

        toolOptionsRoot.setPadding(new Insets(20));
        Scene toolOptionsScene = new Scene(toolOptionsRoot, 300, 700);

        toolOptionsStage.setScene(toolOptionsScene);
        toolOptionsStage.show();


        //Canvas for pixels
        Canvas canvas = new Canvas(20, 20);

        //Init scene
        Scene scene = new Scene(canvas.getPane(), 1000, 1000);

        //Config State
        stage.setTitle("Pixel Paint Program");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}