import java.awt.*;
import java.awt.event.*;

public class npc_plains_quest_collectable extends NPC{


    npc_plains_quest_collectable (int posX, int posY){
        setName("Crystal");
        spriteSheet = loadImage("chara3.png");
        sprite = subImage(spriteSheet,520,0,56,72);
        setMapPosX(posX);
        setMapPosY(posY);

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 4),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
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


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,true,true,"Pick up the Crystal?","","","");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState  currentState){

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState  currentState, String questName, int questStage){

        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName,currentState, questName,questStage);
    }

    public int updateConvo() {
        if (collectItem ) {
            return 98;

        }
        return 0;
    }

    //test code
    boolean collectItem = false;


    public boolean keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    collectItem  = true;
                }
            }
        }

        return super.keyPressed(e);


    }



}
