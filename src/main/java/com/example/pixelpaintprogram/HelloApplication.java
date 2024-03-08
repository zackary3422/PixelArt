package com.example.pixelpaintprogram;

import com.example.pixelpaintprogram.Tools.Tool;
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
import java.util.Objects;

public class HelloApplication extends Application {

    public static Slider redSlider;
    public static Slider blueSlider;
    public static Slider greenSlider;


    @Override
    public void start(Stage stage) throws IOException {


        //Tool Options Scene------------------------------------------------------------------------------------

        Stage toolOptionsStage = new Stage();
        toolOptionsStage.setTitle("Tool Options");

        //Create Color Icon
        Image colorSelectorIcon = new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\ColorSelectorIcon.png");
        ImageView colorSelectorView = new ImageView(colorSelectorIcon );
        colorSelectorView.setFitHeight(50);
        colorSelectorView.setFitWidth(50);

        Button colorSelectorButton = new Button();
        colorSelectorButton.setGraphic( colorSelectorView );

// Create sliders for RGB colors
        redSlider = new Slider(0.0, 1.0, 0.0);
        redSlider.setShowTickLabels(true);
        redSlider.setShowTickMarks(true);
        redSlider.setMajorTickUnit(0.2);
        redSlider.setMinorTickCount(5);
        redSlider.setBlockIncrement(0.1);

        Label sliderLabel = new Label("RED");
        sliderLabel.setLabelFor(redSlider);

        greenSlider = new Slider(0.0, 1.0, 0.0);
        greenSlider.setShowTickLabels(true);
        greenSlider.setShowTickMarks(true);
        greenSlider.setMajorTickUnit(0.2);
        greenSlider.setMinorTickCount(5);
        greenSlider.setBlockIncrement(0.1);

        Label sliderLabelGreen = new Label("GREEN");
        sliderLabelGreen.setLabelFor(greenSlider);

        blueSlider = new Slider(0.0, 1.0, 0.0);
        blueSlider.setShowTickLabels(true);
        blueSlider.setShowTickMarks(true);
        blueSlider.setMajorTickUnit(0.2);
        blueSlider.setMinorTickCount(5);
        blueSlider.setBlockIncrement(0.1);

        Label sliderLabelBlue = new Label("BLUE");
        sliderLabelBlue.setLabelFor( blueSlider);

         //Create Pencil icon
        Image pencilIcon = new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\PencilIcon.png");
        ImageView pencilView = new ImageView(pencilIcon);
        pencilView.setFitHeight(50);
        pencilView.setFitWidth(50);

        Button pencilButton = new Button();
        pencilButton.setGraphic(pencilView );

        pencilButton.setOnAction(e -> {
            Tool.currentTool = Tool.Tools.PENCIL;});

        //Create Pain Bucket Icon
        Image paintIcon = new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\PaintBucketIcon.png");
        ImageView paintView = new ImageView(paintIcon);
        paintView.setFitHeight(50);
        paintView.setFitWidth(50);

        Button paintButton = new Button();
        paintButton.setGraphic(paintView );

        paintButton.setOnAction(e -> {Tool.currentTool = Tool.Tools.PAINTBUCKET;});

        //Create Pain Bucket Icon
        Image eraserIcon = new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\EraserIcon.png");
        ImageView eraserView = new ImageView(eraserIcon);
        eraserView.setFitHeight(50);
        eraserView.setFitWidth(50);

        Button eraserButton = new Button();
        eraserButton.setGraphic(eraserView );

        eraserButton.setOnAction(e -> {
            Tool.currentTool = Tool.Tools.ERASER;});


        VBox toolOptionsRoot = new VBox(10);
        toolOptionsRoot.getChildren().add(colorSelectorView);
        toolOptionsRoot.getChildren().addAll(sliderLabel, redSlider,sliderLabelGreen, greenSlider, sliderLabelBlue, blueSlider);
        toolOptionsRoot.getChildren().add(pencilButton);
        toolOptionsRoot.getChildren().add(paintButton);
        toolOptionsRoot.getChildren().add(eraserButton);


        toolOptionsRoot.setPadding(new Insets(20));
        Scene toolOptionsScene = new Scene(toolOptionsRoot, 300, 550);

        toolOptionsStage.setScene(toolOptionsScene);
        toolOptionsStage.show();



        //---------------------------------------------------------------------------------
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


    public void selectPencil(){
        Tool.currentTool = Tool.Tools.PENCIL;


    }

    public void selectEraser(){
        Tool.currentTool = Tool.Tools.ERASER;


    }

    public void selectPaintBucket(){
        Tool.currentTool = Tool.Tools.PAINTBUCKET;


    }
}