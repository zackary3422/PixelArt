package com.example.pixelpaintprogram.Tools;

import com.example.pixelpaintprogram.Canvas;
import com.example.pixelpaintprogram.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class PaintBucket extends Tool{


    public PaintBucket(){
        super("Paint Bucket", new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\PaintBucketIcon.png"));
    }

    /** Changes current tool to paint bucket*/
    public static void selectPaintBucket(){
        Tool.currentTool = Tool.Tools.PAINTBUCKET;
    }

    /**
     * Selects color for paint bucket and call fill method to fill an area with a specified color from RGB sliders
     */
    public static void paintBucket(int x, int y){

        //Get color from sliders
        Color color = ColorPicker.getColor();

        //Reset changed pixels
        Canvas.changedPixels = new boolean[Canvas.height][Canvas.width];

        //Call fill method
        Color prevColor = Canvas.canvasMap[y][x].getColor();
        fill(x, y, color, prevColor);

        //Document changes to history
        Canvas.addToHistory();
    }

    /**
     * Recursive method that expands left, right, up, and down filling an area with specified color.
     */
    public static void fill(int x, int y, Color newColor, Color prevColor){

        //Exit condition
        if(x < 0 || x >= Canvas.canvasMap[0].length || y < 0 || y >= Canvas.canvasMap.length || !Canvas.canvasMap[y][x].getColor().equals(prevColor) || Canvas.changedPixels[y][x])
            return;

        //Update color and changed pixels
        Canvas.canvasMap[y][x].changeColor(newColor);
        Canvas.changedPixels[y][x] = true;

        //Left
        fill(x - 1, y, newColor, prevColor);

        ///Right
        fill(x + 1, y, newColor, prevColor);

        //Up
        fill(x, y - 1, newColor, prevColor);

        //Down
        fill(x, y + 1, newColor, prevColor);

    }

}
