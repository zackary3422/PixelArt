package com.example.pixelpaintprogram.TestClasses;

import com.example.pixelpaintprogram.Tools.ColorPicker;
import javafx.scene.paint.Color;

public class ToolTest {


    public void colorPickerTest(){

        ColorPicker colorPicker = new ColorPicker();

        if(colorPicker.getName() != null && !colorPicker.getName().isEmpty()){
            System.out.println("Tool Initialized Successfully");
        }
        else{
            System.out.println("Tool Didn't init");
        }


        Color oldColor = Color.RED;
        colorPicker.selectColor(oldColor);

        colorPicker.selectColor(Color.GREEN);

        if(oldColor != ColorPicker.currentColor){
            System.out.println("Color Changes Correctly");
        }else{
            System.out.println("Color Didn't Change");
        }

    }


}
