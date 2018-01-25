import java.awt.*;
import java.awt.event.KeyEvent;

public class cutScene extends extraFunctions {
    //WON'T BE USED FOR A WHILE

    Image background;
    Image backgroundAlt;
    Image smokeSheet;
    Image spriteSheetBjarne;
    Image spriteSheet;
    Image spriteSheet2;
    Image spriteSheet3;
    Image dialogueBack;
    Image dialogueBackSheet;
    Image fade;
    Image startScreen;
    Image fadeArray[];
    Image spriteDown[];
    Image spriteDown2[];
    Image spriteDown3[];
    Image wizardDown[];
    Image wizardSpin[];
    Image smokeArray[];
    Image bjarneUp[];
    double timer;
    double timePast;
    boolean back;
    boolean render;
    boolean vanish;
    boolean start;
    int posX;
    int posY;
    int flameChange;
    int runSpeed;
    int runSpeed2;
    int runSpeedLeft;
    int height;
    int wizardPosX;
    int wizardPosY;
    int BjarnePosX;
    int BjarnePosY;
    int runCount;


    enum introState {text, animation}
    introState state;

    /*
     * Loads all required images
     */
    cutScene(){
        background = loadImage("intro_cutscene.png");
        backgroundAlt = loadImage("intro_cutscene2.png");
        fade = loadImage("fade.png");
        startScreen = loadImage("townPic.png");
        timer = 0;
        timePast = 9999999;
        back = true;
        render = true;
        vanish = false;
        start = false;
        runCount = 0;
        state = introState.text;
        smokeSheet = loadImage("smoke.png");
        spriteSheetBjarne = loadImage("chara1.png");
        spriteSheet = loadImage("scaredRunning.png");
        spriteSheet2 = loadImage("scaredRunning2.png");
        spriteSheet3 = loadImage("chara2.png");
        spriteDown = new Image[3];
        spriteDown2 = new Image[3];
        spriteDown3 = new Image[3];
        wizardDown = new Image[3];
        wizardSpin = new Image[4];
        smokeArray = new Image[35];
        bjarneUp = new Image[3];
        fadeArray = new Image[10];
        dialogueBackSheet = loadImage("dialogue_boxes.png");
        dialogueBack = subImage(dialogueBackSheet,20,20,470,100);
        posX = -800;
        posY = -600;
        runSpeed = 0;
        runSpeed2 = 0;
        runSpeedLeft = 0;
        flameChange = 0;
        height = 0;
        wizardPosX = 120;
        wizardPosY = -74;
        BjarnePosX = 200;
        BjarnePosY = 600;
        for(int i =0; i < 3;i++){
            spriteDown[i] = subImage(spriteSheet,156 + (52 * i), 0,52,72);
            spriteDown2[i] = subImage(spriteSheet,312 + (52 * i), 0,52,72);
            spriteDown3[i] = subImage(spriteSheet2,312 + (52 * i), 0,52,72);
            wizardDown[i] = subImage(spriteSheet3,468 + (52 * i), 288,52,72);
            wizardSpin[i] = subImage(spriteSheet3,520, 288 + (72*i),52,72);
            bjarneUp[i] = subImage(spriteSheetBjarne, (52*i),216,52,72);
        }
        wizardSpin[3] = wizardSpin[2];
        wizardSpin[2] = subImage(spriteSheet3,520, 504,52,72);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                smokeArray[(i*8)+j] = subImage(smokeSheet, j * 128, i * 128, 128, 128);
            }
        }
        smokeArray[32] = subImage(smokeSheet, 0, 512, 128,128);
        smokeArray[33] = subImage(smokeSheet, 128, 512, 128,128);
        smokeArray[34] = subImage(smokeSheet, 256, 512, 128,128);
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                fadeArray[(i*5) + j] = subImage(fade, j*160, i*120, 140, 100);
            }
        }
    }
    /*
     * Updates the timer
     */
    public void updateTimer(double dt){
        timer +=dt;
    }

    /*
     * Draws the whole cutscene
     */
    public void drawCutScene(Graphics2D g){
        if(state == introState.text) {
            clearBackground(800, 600, g);
            changeBackgroundColor(black, g);
            changeColor(white, g);

            if ((timer > 2) && (timer < 8)) {
                changeColor(grey1, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.1) && (timer < 8)) {
                changeColor(grey2, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.2) && (timer < 8)) {
                changeColor(grey3, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.3) && (timer < 8)) {
                changeColor(grey4, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.5) && (timer < 8)) {
                changeColor(grey5, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.6) && (timer < 8)) {
                changeColor(grey6, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 2.7) && (timer < 8)) {
                changeColor(white, g);
                clearBackground(800, 600, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 6.9) && (timer < 8)) {
                changeColor(grey6, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 7) && (timer < 8)) {
                changeColor(grey5, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 7.1) && (timer < 8)) {
                changeColor(grey4, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 7.2) && (timer < 8)) {
                changeColor(grey3, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 7.3) && (timer < 8)) {
                changeColor(grey2, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 7.4) && (timer < 8)) {
                changeColor(grey1, g);
                drawBoldText(180, 255, "In a far off land, the dark", g);
                drawBoldText(60, 300, "wizard Therox was pillaging villages", g);
                drawBoldText(110, 345, "in a hunt for power and fortune.", g);
            }
            if ((timer > 7.5) && (timer < 8)) {
                clearBackground(800, 600, g);
                state = introState.animation;
            }
        }
        if(state == introState.animation){
            flameChange++;

            if(flameChange % 3 == 0){
                back = !back;
            }
            if(back && !start){
                drawImage(background, posX, posY, g);
            } else{
                drawImage(backgroundAlt, posX, posY, g);
            }
            if(start){
               drawImage(startScreen, 0, 0, g);
            }
            if((posY + 200 + runSpeed) <450) {
                runSpeed+=2;
                drawImage(spriteDown[flameChange % 3], posX + 857, posY + 1000 + runSpeed, g);
                drawImage(spriteDown2[flameChange % 3], posX + 1020, posY + 200 + runSpeed, g);
                height = runSpeed;
            }
            if(render) {
                runSpeed2 += 1;
                runSpeedLeft += 1;
                drawImage(spriteDown2[flameChange % 3], posX + 1020, posY + 200 + height, g);
                drawImage(spriteDown3[flameChange % 3], posX + 1200 + runSpeedLeft, posY + 180 + runSpeed, g);
                //Need if condition to break loop
                if((posY + 200 + height) > 800){
                    render = false;
                }
            }
            if(posY < 0) {
                posX+=2;
                posY+=2;
            }
            if((posY >= 0) && (wizardPosY < 50)){
                wizardPosY+=1;
                drawImage(wizardDown[flameChange % 3], wizardPosX, wizardPosY, g);
                timePast = timer + 5;
            }
            if((posY >= 0) && (wizardPosY >= 50)){
                if(timePast > timer) {
                    wizardPosY += 1;
                    changeColor(white, g);
                    drawImage(wizardDown[1], wizardPosX, 50, g);
                    drawImage(dialogueBack, 90, 400, 620, 165, g);
                    drawText(110, 450, "MWA HA HA HA! There's no stopping me now! Once I gain control", "Times New Roman", 20, g);
                    drawText(110, 475, "of the Seven Crystals of the South, my power will be un-matchable!", "Times New Roman", 20, g);
                }
            }
            if((timePast < timer) && (posY>=0) && (timer < 32)){
                drawImage(wizardSpin[flameChange % 4], wizardPosX, 50, g);
            }
            if((timer > 32) && !vanish){
                drawImage(smokeArray[flameChange%34], 80, 0, g);
                runCount++;
                if(runCount >=20){
                    vanish = true;
                }
            }
            if((timer > 34) && vanish && (BjarnePosY > 550)){
                BjarnePosY-=2;
                drawImage(bjarneUp[flameChange%3], BjarnePosX, BjarnePosY, g);
            }
            if((BjarnePosY <= 550) && timer < 40){
                drawImage(bjarneUp[1], BjarnePosX, 550, g);
                changeColor(white, g);
                drawImage(dialogueBack, 90, 400, 620, 165, g);
                drawText(110, 450, "HOW DARE YOU! MY HOME... MY-MY FAMILY! YOU'LL PAY FOR", "Times New Roman", 20, g);
                drawText(110, 475, "THIS! I'll travel East to the town of ______ to warn them. They need to ", "Times New Roman", 20, g);
                drawText(110, 500, "be prepared.", "Times New Roman", 20, g);
            }
            if(timer > 40){
                if(timer > 40 && timer < 42){
                    drawImage(fadeArray[0], 0,0,800,600,g);
                }
                if(timer > 40.1 && timer < 40.2){
                    drawImage(fadeArray[1], 0,0,800,600,g);
                }
                if(timer > 40.2 && timer < 40.3){
                    drawImage(fadeArray[2], 0,0,800,600,g);
                }
                if(timer > 40.3 && timer < 40.4){
                    drawImage(fadeArray[3], 0,0,800,600,g);
                }
                if(timer > 40.4 && timer < 40.5){
                    drawImage(fadeArray[4], 0,0,800,600,g);
                }
                if(timer > 40.5 && timer < 40.6){
                    drawImage(fadeArray[5], 0,0,800,600,g);
                }
                if(timer > 40.6 && timer < 40.7){
                    drawImage(fadeArray[6], 0,0,800,600,g);
                }
                if(timer > 40.7 && timer < 40.8){
                    drawImage(fadeArray[7], 0,0,800,600,g);
                }
                if(timer > 40.8 && timer < 40.9){
                    drawImage(fadeArray[8], 0,0,800,600,g);
                }
                if(timer > 40.9 && timer < 41){
                    drawImage(fadeArray[9], 0,0,800,600,g);
                }
                if(timer > 41 && timer < 42){
                    drawImage(fadeArray[9], 0,0,800,600,g);
                    start = true;
                }
                if(timer > 42 && timer < 42.1){
                    drawImage(fadeArray[9], 0,0,800,600,g);
                }
                if(timer > 42.1 && timer < 42.2){
                    drawImage(fadeArray[8], 0,0,800,600,g);
                }
                if(timer > 42.2 && timer < 42.3){
                    drawImage(fadeArray[7], 0,0,800,600,g);
                }
                if(timer > 42.3 && timer < 42.4){
                    drawImage(fadeArray[6], 0,0,800,600,g);
                }
                if(timer > 42.4 && timer < 42.5){
                    drawImage(fadeArray[5], 0,0,800,600,g);
                }
                if(timer > 42.5 && timer < 42.6){
                    drawImage(fadeArray[4], 0,0,800,600,g);
                }
                if(timer > 42.6 && timer < 42.7){
                    drawImage(fadeArray[3], 0,0,800,600,g);
                }
                if(timer > 42.7 && timer < 42.8){
                    drawImage(fadeArray[2], 0,0,800,600,g);
                }
                if(timer > 42.8 && timer < 42.9){
                    drawImage(fadeArray[1], 0,0,800,600,g);
                }
                if(timer > 42.9 && timer < 43){
                    drawImage(fadeArray[0], 0,0,800,600,g);
                }
                if(timer > 43){
                    changeColor(white, g);
                    drawText(220, 500, "- Press <SPACE> to begin your adventure -",  "New Roman Times", 20, g);
                }
            }
        }
    }

    public int keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            return 1;
        }
        return 0;
    }


}

