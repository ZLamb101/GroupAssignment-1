import java.awt.*;
import java.awt.event.KeyEvent;

public class NPC extends extraFunctions{

    private String name; //< Name of the object
    Image sprite; //< The associated

    Image[] spriteUp; //< 3 per
    Image[] spriteDown;
    Image[] spriteRight;
    Image[] spriteLeft;
    Image spriteSheet;

    private double mapPosX; //<  NPC's map position X
    private double mapPosY; //< NPC's map position Y

    private int mapLocation; //< Npc's located Map

    private boolean hostile;

    private double height;
    private double width;



    double moveTimer;
    double moveDelay;

    double[] location;

    int currentLocation;




    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public double getLocation(int index) {
        return location[index];
    }

    public void setLocation(int index,double location) {
        this.location[index] = location;
    }


    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int moveDirection) {
        this.currentLocation = moveDirection;
    }

    public double getMoveTimer() {
        return moveTimer;
    }

    public void setMoveTimer(double moveTimer) {
        this.moveTimer = moveTimer;
    }

    public double getMoveDelay() {
        return moveDelay;
    }

    public void setMoveDelay(double moveDelay) {
        this.moveDelay = moveDelay;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getName(){
        return name;
    }

    public void setName(String x){
        this.name = x;
    }



    public int getMapLocation(){
        return mapLocation;
    }

    public void setMapLocation(int location){
        this.mapLocation = location;
    }

    public void setMapPos(double posX, double posY){
        this.mapPosX = posX;
        this.mapPosY = posY;
    }

    public double getMapPosX(){
        return mapPosX;
    }

    public double getMapPosY(){
        return mapPosY;
    }

    public void setHostile(boolean side){
        this.hostile = side;
    }

    public boolean getHostile(){
        return hostile;
    }

    public void setUpCollision(Collision collisionDetector, extraFunctions map){

    }

    public void updateNpcMovement(double dt,Collision collisionDetector){


    }


    public void loadImages(){
        spriteLeft = new Image[3];
        spriteRight = new Image[3];
        spriteUp = new Image[3];
        spriteDown = new Image[3];
        walkTimer = 0;
        walkDuration = 0.16;

        npcDown = false;
        npcUp = false;
        npcLeft = false;
        npcRight = false;
    }

    enum Direction {up,down,left,right};
    Direction npcDirection;

    boolean npcRight,npcLeft, npcUp, npcDown;

    double walkTimer;
    double walkDuration ;



    public void drawNpcMovement(Graphics g){

        drawImage(sprite,mapPosX,mapPosY,50,70,g);

    }


     public int updateConvo(){
        return 0;
     }


    public void drawConvo(Graphics2D g,String playerName, Quest.questState  state, String questName){
        changeColor(black, g);
        drawSolidRectangle(100,400,600,150,g);
        changeColor(Color.white,g);
        drawRectangle(100,400,600,150,10,g);
        drawText( 110,425,getName() + ": ","Times New Roman",20,g);
    }


    public boolean keyPressed(KeyEvent e){
        return false;
    }

}
