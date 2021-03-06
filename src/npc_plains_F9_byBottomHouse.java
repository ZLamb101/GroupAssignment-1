import java.awt.*;
import java.awt.event.*;


public class npc_plains_F9_byBottomHouse extends  NPC {



    npc_plains_F9_byBottomHouse(){
        setName("Tyran");
        spriteSheet = loadImage("Image/chara2.png");
        sprite = subImage(spriteSheet,196,0,56,72);
        setMapPosX(150);
        setMapPosY(450);

        turnArray = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            turnArray[i] = subImage(spriteSheet,196,0 + (i * 72),56,72);
        }
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
        turn();
    }

    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    Dialogue listOne;

    Dialogue listTwo;

    Dialogue listThree;


    public void initDialogue() {
        Dialogue d1 = new Dialogue(null,false,true,"Therox's witches have been driving packs of wolves at the town. The ", "militia can't handle it, they've already lost two good men!","","");
        listOne = d1;

        Dialogue d2 = new Dialogue(null,false,true,"Hey Bjarne, I've noticed the priest has been visiting this house ","a lot. It seems a little suspicious.","","");
        listTwo = d2;

        Dialogue d3 = new Dialogue(null,false,true,"That was incredible Bjarne! All of us here in Sepla owe you our","lives! ","","");
        listThree = d3;
    }

    public void updateDialogue(int questStage){
        if(questStage < 13) {
            currentDialogue = listOne;
        }else if(questStage >= 33) {
            currentDialogue = listThree;
        } else{
            currentDialogue = listTwo;
        }

    }

    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){

        if(loadDialogue) {
            updateDialogue(questStage);
            loadDialogue = false;
        }
        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }



}
