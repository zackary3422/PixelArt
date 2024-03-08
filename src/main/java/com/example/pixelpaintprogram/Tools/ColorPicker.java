package com.example.pixelpaintprogram.Tools;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ColorPicker extends Tool{

    public static Color currentColor;

    public ColorPicker(){
        super("Color Selector", new Image("ColorSelectorIcon.png"));
    }

    public void selectColor(Color newColor){
        currentColor = newColor;
    }

}
