import java.awt.*;
import java.awt.event.*;

//MOVED TO H9
public class npc_plains_Dijkstra extends  NPC {



    npc_plains_Dijkstra(){
        setName("Dijkstra");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,52,288,56,72);
        setMapPosX(400);
        setMapPosY(300);

        initDialogue(); //new
        loadDialogue = true; // new
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }


    /////////////////////////////////////////
    ///
    ///  Movement
    ///
    //////////////////////////////////////////

    @Override
    public void updateNpcMovement(double dt,Collision collisionDetector){

    }


    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////


    Dialogue listOne;

    Dialogue listTwo;

    Dialogue listThree;
    Dialogue listFour;

    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"If i'm honest i'm a bit lost. There's so many monsters around here,","thankfully I have these potions to save me!","","");
        listOne = d1;

        Dialogue d3 = new Dialogue(null,true,true,"Go Search the picture frame in the church, And then visit Camrath the blacksmith.","","","");
        Dialogue d2 = new Dialogue(d3,false,false,"Hello Adventurer, I know why you are here.....","I can get you to Therox. although it will not be easy","I hid something in the church many years ago.","Go to the church and search behind the picture frame.");
        listTwo = d2;

        Dialogue d4 = new Dialogue(null,false,true,"The church is just west of here. ","Take what you find to Camrath.","","");
        listThree = d4;
    }

    public void updateDialogue(int questStage){

        if(questStage < 21) {
            currentDialogue = listOne;
        }else {
            switch (questStage) {
                case 21:
                    currentDialogue = listTwo;
                    break;
                case 22:
                case 23:
                    currentDialogue = listThree;
                    break;
            }

        }

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
    }


    public int updateConvo(){
        switch (this.questStage){
            case 22:
                currentDialogue = listThree;
                return 22;
            default:
                return 0;

        }

    }









    public boolean keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    switch (questStage) {
                        case 21:
                            questStage = 22;
                            break;
                    }
                }
            }
        }

        return super.keyPressed(e);


    }






}
