import java.awt.*;
import java.awt.event.*;


public class npc_plains_E8_signGrave extends  NPC {

    npc_plains_E8_signGrave(){
        setName("Sepla Graveyard");
        spriteSheet = loadImage("Image/chara5.png");
        sprite = subImage(spriteSheet,50,0,1,1);
        setMapPosX(255);
        setMapPosY(470);

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void setUpCollision(Collision collisionDetector,Map map){
        //collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 5),((int)getWidth()/10 - 2),((int)getHeight()/10 - 2),map.isFlicker());
    }

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
        Dialogue d1 = new Dialogue(null,false,true,"Here lies all lines of cut code. ","","","");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState  currentState){

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }


}
