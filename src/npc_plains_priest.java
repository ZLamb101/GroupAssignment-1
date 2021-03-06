import java.awt.*;
import java.awt.event.*;


public class npc_plains_priest extends  NPC {



    npc_plains_priest(int posX, int posY){
        setName("Priest");
        spriteSheet = loadImage("Image/chara2.png");
        sprite = subImage(spriteSheet,364,0,56,72);
        setMapPosX(posX);
        setMapPosY(posY);

        initDialogue();
        loadDialogue = true;
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


    int npcDeaths;
    Dialogue listOne;

    Dialogue listTwo;

    Dialogue listThree;


    public void initDialogue() {

        Dialogue d1 = new Dialogue(null,false,true,"Hello little man, you seem weak... ","I would consider changing your faith before the end comes!","","");
        listOne = d1;

        Dialogue d4 = new Dialogue(null,true,true,"Or will you try to stop me? Mwa ha ha ha!","","","");
        Dialogue d3 = new Dialogue(d4,false,false, "The dark lord is near, you have lost and now your friend Julian","shall die.","","");
        Dialogue d2 = new Dialogue(d3,false,false, "Hello again little man. I see you found my book, well no ","problem, the time has come for action!","","");
        listTwo = d2;


        Dialogue d6 = new Dialogue(null,false,true,"Now let's go little man!","","","");
        Dialogue d5 = new Dialogue(d6,false,false,"Oh that was too easy! Mee-oh-my I did enjoy that!","A good warm up!","","");
        listThree = d5;




    }

    public void updateDialogue(int questStage,int npcDeaths){
        if(questStage < 15) {
            currentDialogue = listOne;
        }
        if(questStage == 15){
            if(npcDeaths == 0) {
                currentDialogue = listTwo;
            }else{
                currentDialogue = listThree;
            }
        }

    }



    public void drawConvo(Graphics2D g, Quest.questState  currentState, String questName, int questStage, int npcDeaths){
        this.npcDeaths = npcDeaths;
        this.questStage = questStage;
        if(loadDialogue) {
            updateDialogue(questStage,npcDeaths);
            loadDialogue = false;
        }

        super.drawConvo(g,currentState, questName,questStage,npcDeaths);
    }

    public int updateConvo() {
        if (summonMonster) {
            summonMonster =false;
            return 99;

        }
        if(killnpc){
            killnpc = false;
            return 93;
        }
        return 0;
    }

    //test code
    boolean summonMonster = false;
    boolean killnpc = false;

    public boolean keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {


            if (currentDialogue.next == null && questStage == 15) {


                if(npcDeaths == 0 ) {
                    if (currentDialogue.getOptionPosY() == 375) {
                        summonMonster = true;
                    } else {
                        killnpc = true;
                        currentDialogue = listThree;
                        return false;
                    }
                }else{
                    summonMonster = true;
                }
            }
        }

        return super.keyPressed(e);


    }





}
