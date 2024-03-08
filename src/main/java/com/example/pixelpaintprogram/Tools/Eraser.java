package com.example.pixelpaintprogram.Tools;

import com.example.pixelpaintprogram.Canvas;
import com.example.pixelpaintprogram.Pixel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Eraser extends Tool{

    public Eraser(){
        super("Eraser", new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\EraserIcon.png"));

    }

    /**
     * Selects eraser tool
     * */
    public static void selectEraser(){
        Tool.currentTool = Tool.Tools.ERASER;
    }

    /**
     * Changes a pixel color to white
     * */
    public static void erase(Pixel pixel){
        pixel.changeColor(new Color(1, 1, 1, 1.0));
        Canvas.addToHistory();
    }

}
