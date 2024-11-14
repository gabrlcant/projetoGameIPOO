import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (gabriel cantanhede) 
 * @version (2024-11-24)
 */
public class background extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        GreenfootImage background = new GreenfootImage(800,600);
        background.setColor(Color.BLACK);
        background.fillRect(0,0,800,600);
        setBackground(background);
    }
}
