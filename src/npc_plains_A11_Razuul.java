import java.awt.*;
import java.awt.event.*;

public class npc_plains_A11_Razuul extends NPC{


    npc_plains_A11_Razuul() {
        setName("Razuul");
        spriteSheet = loadImage("chara5.png");
        sprite = subImage(spriteSheet,364,0,56,72);
        setMapPosX(320);
        setMapPosY(200);

        spriteLeft = new Image[3];
        spriteRight = new Image[3];

        initDialogue();
        loadDialogue = true;
    }

    @Override
    public void loadImages(){
        super.loadImages();
        //Load Images here
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,312 + (52 * i), 288,52,72);
            spriteLeft[i] = subImage(spriteSheet,312 + (52 * i), 360,52,72);
        }
    }

    @Override
    public void setUpCollision(Collision collisionDetector, Map map) {
        collisionDetector.addBoxCollision(((int) getMapPosX() / 10 - 2), ((int) getMapPosY() / 10 - 4), ((int) getWidth() / 10 - 2), ((int) getHeight() / 10 - 2), map.isFlicker());
    }

    @Override
    public void undoCollision(Collision collisionDetector){
        collisionDetector.addBoxCollision(((int)getMapPosX()/ 10 - 2),((int)getMapPosY()/10 - 4),((int)getWidth()/10-2),((int)getHeight()/10 - 2),false);
    }

    /////////////////////////////////////////
    ///
    ///  Movement
    ///
    //////////////////////////////////////////

    @Override
    public void updateNpcMovement(double dt, Collision collisionDetector) {

    }


    /////////////////////////////////////////
    ///
    ///  Convo
    ///
    //////////////////////////////////////////

    Dialogue listOne;


    public void initDialogue() {
//        Dialogue d3 = new Dialogue(null, true, true, "We have seen your defiance, and it can continue no longer!", "Prepare yourself!", "", "" );
//        Dialogue d2 = new Dialogue(d3, false, false, "I am Valliard! Lieutenant of the Flame Guard! My careful study of ", "war and magic will make you cower before me!", "", "" );
        Dialogue d1 = new Dialogue(null, false, false, "What a surprise it is to see you here little man! Wanted another", "crack at taking down the mighty Razuul did you? Well", "come and get it!", "");
        listOne = d1;
    }

    public void updateDialogue(Quest.questState currentState) {

        currentDialogue = listOne;

    }

    public void drawConvo(Graphics2D g, String playerName, Quest.questState currentState, String questName, int questStage) {

        if (loadDialogue) {
            updateDialogue(currentState);
            loadDialogue = false;
        }
        super.drawConvo(g, playerName, currentState, questName, questStage);
    }

    public int updateConvo() {
        if (summonMonster) {
            return 99;

        }
        return 0;
    }

    //test code
    boolean summonMonster = false;


    public boolean keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (currentDialogue.next == null) {
                if (currentDialogue.getOptionPosY() == 375) {
                    summonMonster = true;
                }
            }
        }

        return super.keyPressed(e);


    }






}
