package com.example.pixelpaintprogram;

import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Canvas {

    /** Width and Height of canvas in terms of pixels*/
    public static int width = 0;
    public static int height = 0;

    /** The canvas map of pixels*/
    public static Pixel[][] canvasMap;

    /** The history of all changes made to the canvas map stored as a list of arrays of color*/
    private static ArrayList<Color[][]> canvasHistory;

    /** Keeps track of the current history index when going back and forth between changes made in history*/
    private static int currentHistoryIndex = 0;

    /** Container for all the pixels*/
    private Pane pane = new Pane();

    /** Array for keeping track of changed pixels for the paint bucket tool*/
    public static boolean[][] changedPixels = new boolean[height][width];

    /**
     * Constructor
     * @param width the numbers of pixels for the width of the board
     * @param height the number of pixels for the height of the
     * */
    public Canvas(int width, int height){

        Canvas.width = width;
        Canvas.height = height;

        canvasHistory = new ArrayList<Color[][]>();

        canvasMap = new Pixel[height][width];

        initCanvas();
        addToGridPane();
        addToHistory();
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
     * Adds the current canvas colors to the history list and if current history isn't at the front
     * then truncate all history to the right of current history index
     * */
    public static void addToHistory(){

        for(int i = currentHistoryIndex+1; i < canvasHistory.size(); i++) {
            canvasHistory.remove(i);
            i--;
        }

        Color[][] copy = new Color[height][width];

        //copy contents
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                copy[i][j] = canvasMap[i][j].getColor();
            }
        }

        canvasHistory.add(copy);

        currentHistoryIndex = canvasHistory.size() - 1;
    }

    /**
     * Loads history based on index onto canvas map
     * */
    public static void loadHistory(int index){

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


    /** Go back one in canvas history and load it to canvas*/
    public static void backInHistory(){

        if(currentHistoryIndex == 0)
            return;

        currentHistoryIndex--;

        loadHistory(currentHistoryIndex);

    }

    /** Go forward one in canvas history and load it to canvas*/
    public static void forwardInHistory(){

        if(currentHistoryIndex == canvasHistory.size()-1)
            return;

        currentHistoryIndex++;

        loadHistory(currentHistoryIndex);

    }





}
