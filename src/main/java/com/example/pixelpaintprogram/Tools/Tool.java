package com.example.pixelpaintprogram.Tools;

import javafx.scene.image.Image;

public abstract class Tool {

    /** Name for the tool*/
    private String name;

    /** Image icon to represent the tool*/
    private Image icon;

    public enum Tools {PENCIL, ERASER, PAINTBUCKET};
    public static Tools currentTool;

    /**
     * Abstract constructor
     * @param name for the tool
     * @param icon for the tool
     * */
    public Tool(String name, Image icon){
        this.name = name;
        this.icon = icon;
    }

    /** @return name of tool*/
    public String getName(){
        return name;
    }

    /** @return icon of tool*/
    public Image getImage(){
        return icon;
    }

}
