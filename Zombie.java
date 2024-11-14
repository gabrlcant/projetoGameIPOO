import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (gabriel cantanhede) 
 * @version (2024-11-14)
 */
public class Zombie extends Actor
{
    private GreenfootImage[] frontWalk;
    private GreenfootImage[] backWalk;
    private GreenfootImage[] rightWalk;
    private GreenfootImage[] leftWalk;
    private int indexActualImage;
    private int passToUpdate;
    private int passUntilLastUpdate;
    private boolean isMoving;
    
    public Zombie(){
        passToUpdate = 5;
        passUntilLastUpdate = 0;
        frontWalk = new GreenfootImage[9];
        backWalk = new GreenfootImage[9];
        rightWalk = new GreenfootImage[9];
        leftWalk = new GreenfootImage[9];
        isMoving = false;
        
        for(int i = 0; i < frontWalk.length; i++){
            frontWalk[i] = new GreenfootImage("tile00"+(i)+".png");
            frontWalk[i].scale(220,240);
        }
        
        for(int i = 0; i < (leftWalk.length); i++){
            leftWalk[i] = new GreenfootImage("left ("+(i+1)+").png");
            leftWalk[i].scale(220,240);
        }
        
        for(int i = 0; i < (rightWalk.length); i++){
            rightWalk[i] = new GreenfootImage("right ("+(i+1)+").png");
            rightWalk[i].scale(220,240);
        }
        
        for(int i = 0; i < (backWalk.length); i++){
            backWalk[i] = new GreenfootImage("back ("+(i+1)+").png");
            backWalk[i].scale(220,240);
        }

        indexActualImage = 0;
        setImage(frontWalk[0]);
        
    }
    
    public void act(){
        isMoving = false;
        
        if(Greenfoot.isKeyDown("right")){
            moveRight();
            setLocation(getX()+4, getY());
            isMoving = true;
        }
        if(Greenfoot.isKeyDown("down")){
            idle();
            setLocation(getX(), getY()+4);
            isMoving = true;
        }
        if(Greenfoot.isKeyDown("up")){
            moveBack();
            setLocation(getX(), getY()-4);
            isMoving = true;
        }
        if(Greenfoot.isKeyDown("left")){
            moveLeft();
            setLocation(getX()-4, getY());
            isMoving = true;
        }
        if(!isMoving){
            idle();
        }
    }
    
    public void idle()
    {
        passUntilLastUpdate++;
        if(passUntilLastUpdate == passToUpdate){
            indexActualImage++;
            if(indexActualImage >= frontWalk.length){
                indexActualImage = 0;
            }
            setImage(frontWalk[indexActualImage]);
            passUntilLastUpdate = 0;
        }  
    }
    
    public void moveRight()
    {
        passUntilLastUpdate++;
        if(passUntilLastUpdate == passToUpdate){
            indexActualImage++;
            if(indexActualImage >= rightWalk.length){
                indexActualImage = 0;
            }
            setImage(rightWalk[indexActualImage]);
            passUntilLastUpdate = 0;
        }  
    }
    
    public void moveLeft()
    {
        passUntilLastUpdate++;
        if(passUntilLastUpdate == passToUpdate){
            indexActualImage++;
            if(indexActualImage >= leftWalk.length){
                indexActualImage = 0;
            }
            setImage(leftWalk[indexActualImage]);
            passUntilLastUpdate = 0;
        }  
    }
    
    public void moveBack()
    {        
        passUntilLastUpdate++;
        if(passUntilLastUpdate == passToUpdate){
            indexActualImage++;
            if(indexActualImage >= backWalk.length){
                indexActualImage = 0;
            }
            setImage(backWalk[indexActualImage]);
            passUntilLastUpdate = 0;
        }  
    }
    
}
