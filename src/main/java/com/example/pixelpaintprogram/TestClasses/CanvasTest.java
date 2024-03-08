package com.example.pixelpaintprogram.TestClasses;

import com.example.pixelpaintprogram.Canvas;

public class CanvasTest {



    public void testCanvasInit(){

        Canvas canvas = new Canvas(10, 10);

        if(canvas.getPane() != null){
            System.out.println("Successful init of canvas");
        }
        else{
            System.out.println("Canvas not successfully initalized");
        }

    }




}
