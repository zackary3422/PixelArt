package com.example.pixelpaintprogram.Tools;

import com.example.pixelpaintprogram.HelloApplication;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ColorPicker extends Tool{

    public static Color currentColor;

    public ColorPicker(){
        super("Color Selector", new Image("file:C:\\Users\\zackd\\Downloads\\PixelPaintProgram\\src\\main\\resources\\Images\\ColorSelectorIcon.png"));
    }

    /** Returns current color selected in RGB sliders*/
    public static Color getColor(){
        //Get color from sliders
        double red = HelloApplication.redSlider.getValue();
        double blue = HelloApplication.blueSlider.getValue();
        double green = HelloApplication.greenSlider.getValue();
        return new Color(red, green, blue, 1);
    }



}
