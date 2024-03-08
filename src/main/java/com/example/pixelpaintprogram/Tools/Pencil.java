package com.example.pixelpaintprogram.Tools;

import com.example.pixelpaintprogram.Canvas;
import com.example.pixelpaintprogram.HelloApplication;
import com.example.pixelpaintprogram.Pixel;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Pencil extends Tool{

    public Pencil(){
        super("Pencil", new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\PencilIcon.png"));
    }

    /** Changes the current tool to pencil*/
    public static void selectPencil(){
        Tool.currentTool = Tool.Tools.PENCIL;
    }

    /** Change color of provided pixel*/
    public static void changeColor(Pixel pixel){

        pixel.changeColor(ColorPicker.getColor());

        Canvas.addToHistory();
    }

}
