package com.example.pixelpaintprogram;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Canvas {

    /** Width and Height of canvas in terms of pixels*/
    public static int width = 0;
    public static int height = 0;

    /** The canvas map of pixels*/
    private static Pixel[][] canvasMap;

    /** The history of all changes made to the canvas map stored as a list of arrays of color*/
    private ArrayList<Color[][]> canvasHistory;

    private int currentHistoryIndex = 0;

    private Pane pane = new Pane();

    /**
     * Constructor
     * @param width the numbers of pixels for the width of the board
     * @param height the number of pixels for the height of the board*/
    public Canvas(int width, int height){

        Canvas.width = width;
        Canvas.height = height;

        canvasHistory = new ArrayList<Color[][]>();

        canvasMap = new Pixel[height][width];

        initCanvas();
        addToGridPane();
    }

    /**
     * Fills canvas map with pixels set to a default color
     * */
    private void initCanvas(){

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                canvasMap[i][j] = new Pixel(Color.WHITE, j, i);
            }
        }

    }

    /**
     *  Adds all the pixel rectangles to the pane
     *  */
    public void addToGridPane(){

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
               pane.getChildren().add(canvasMap[i][j].rectangle);
            }
        }

    }

    /**
     * Adds the current canvas colors to the history list
     * */
    public void addToHistory(){

        Color[][] copy = new Color[height][width];

        //copy contents
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                copy[i][j] = canvasMap[i][j].getColor();
            }
        }

        canvasHistory.add(copy);

    }

    /**
     * Loads history based on index onto canvas map*/
    public void loadHistory(int index){

        currentHistoryIndex = index;

        //Change current Canvas
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                canvasMap[i][j].changeColor(canvasHistory.get(index)[i][j]);
            }
        }

    }

    /**
     * Get a copy of the board
     * @return a copy of the canvas map values
     * */
    public Pixel[][] getCopy(){

        Pixel[][] copy = new Pixel[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){

            }
        }

        return copy;
    }

    /**
     * Adds current pane to history and sets current map to the new one
     * @param newCanvas the new canvas to be displayed
     * */
    public void addNewCanvas(Pixel[][] newCanvas){
        addToHistory();

        canvasMap = newCanvas;
    }

    /**
     * Returns the pane of the canvas holding the pixels
     * @return main pane of canvas
     * */
    public Pane getPane(){
        return pane;
    }

    /**
     *
     */
    public static void paintBucket(int x, int y){



    }

}
