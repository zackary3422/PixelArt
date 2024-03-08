package com.example.pixelpaintprogram;

import com.example.pixelpaintprogram.Tools.Eraser;
import com.example.pixelpaintprogram.Tools.PaintBucket;
import com.example.pixelpaintprogram.Tools.Pencil;
import com.example.pixelpaintprogram.Tools.Tool;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pixel {

    /** The width and height of a pixel rectangle */
    public static float pixelLength = 50;

    /** The rectangle to represent a pixel*/
    public Rectangle rectangle;

    /** The color of this pixel*/
    private Color color;

    /** Coordinates of pixel*/
    int x, y;

    /**
     * Constructor of a pixel
     * @param color set init color of pixel
     * @param x position of pixel
     * @param y position of pixel
     * */
    public Pixel(Color color, int x, int y){

        this.color = color;

        rectangle = new Rectangle(pixelLength * x, pixelLength * y, pixelLength,pixelLength);
        rectangle.setFill(color);
        rectangle.setOnMouseClicked(event -> {
            clicked();
        });

        this.x = x;
        this.y = y;

    }

    public Pixel(){

    }

    /** @return color of pixel*/
    public Color getColor(){
        return color;
    }

    @Override
    public String toString(){
        return "Pixel - Color: " + color.toString() + " Width: " + pixelLength + " Height: " + pixelLength;
    }

    /**
     * Change the current color of pixel
     * @param color new color
     * */
    public void changeColor(Color color){
        this.color = color;
        rectangle.setFill(color);
    }

    /**
     * Call tool methods when
     * */
    public void clicked(){

        if(Tool.currentTool == Tool.Tools.PENCIL)
            Pencil.changeColor(this);
        else if (Tool.currentTool == Tool.Tools.ERASER)
            Eraser.erase(this);
        else{
            PaintBucket.paintBucket(x, y);
        }
    }






}
