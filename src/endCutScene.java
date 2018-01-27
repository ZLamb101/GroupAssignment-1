import java.awt.*;
import java.awt.event.KeyEvent;

public class endCutScene extends extraFunctions{

    Image spriteSheet;
    Image spriteSheet2;
    Image spriteSheet3;
    Image bossBack;
    Image plainsBack;
    Image Bjarne[];
    Image BjarneSpin[];
    Image WizardSpin[];
    Image WizardGood[];
    Image WizardBad;
    Image fadeArray[];
    Image dialogueBackSheet;
    Image dialogueBack;
    Image smokeSheet;
    Image smokeArray[];
    Image fade;
    Image Dijkstra;
    Image Camrath;
    int animationChange;
    int runCount;
    boolean vanish;
    boolean change;
    double timer;


    endCutScene(){
        timer = 0;
        fade = loadImage("fade.png");
        smokeSheet = loadImage("smoke.png");
        bossBack = loadImage("bossFight.png");
        plainsBack = loadImage("plains_E5.png");
        spriteSheet = loadImage("chara1.png");
        spriteSheet2 = loadImage("chara3.png");
        spriteSheet3 = loadImage("chara2.png");

        Dijkstra = subImage(spriteSheet3, 520, 0,56,72);
        Camrath = subImage(spriteSheet2, 52, 288, 56, 72);

        vanish = false;
        change = false;
        runCount = 0;
        animationChange = 0;
        WizardSpin = new Image[4];
        BjarneSpin = new Image[4];
        Bjarne = new Image[3];
        WizardGood = new Image[3];
        fadeArray = new Image[10];
        smokeArray = new Image[35];
        dialogueBackSheet = loadImage("dialogue_boxes.png");
        dialogueBack = subImage(dialogueBackSheet,20,20,470,100);

        for(int i =0; i < 3;i++){
            WizardSpin[i] = subImage(spriteSheet,52, 288 + (72*i),52,72);
            BjarneSpin[i] = subImage(spriteSheet,52, 72*i,52,72);
        }
        WizardSpin[3] = WizardSpin[2];
        WizardSpin[2] = subImage(spriteSheet,52, 504,52,72);
        BjarneSpin[3] = BjarneSpin[2];
        BjarneSpin[2] = subImage(spriteSheet,52, 216,52,72);
        WizardBad = subImage(spriteSheet, 52, 288, 52, 72);
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

    public void updateTimer(double dt){
        timer +=dt;
    }

    public void drawCutScene(Graphics2D g) {
        animationChange++;
        System.out.println(timer);
        if(!change) {
            drawImage(plainsBack, 0, 0, g);
            drawImage(Dijkstra, 400, 300, 50, 70, g);
            drawImage(Camrath, 500, 250, 50, 70, g);
        } else {
            drawImage(bossBack, 0, 0, g);
        }
        if(timer < 1) {
            drawImage(WizardSpin[animationChange % 4], 300, 250, 50, 70, g);
            drawImage(BjarneSpin[animationChange % 4], 400, 315, 50, 70, g);
        }
        if((timer > 1) && !vanish){
            drawImage(Dijkstra, 400, 300, 50, 70, g);
            drawImage(Camrath, 500, 250, 50, 70, g);
            drawImage(smokeArray[animationChange%34], 250, 200, g);
            drawImage(smokeArray[animationChange%34], 350, 265, g);
            runCount++;
            if(runCount >=20){
                vanish = true;
            }
        }
        if(timer > 2 && vanish){
            if(timer > 2 && timer < 42){
                drawImage(fadeArray[0], 0,0,800,600,g);
            }
            if(timer > 2.1 && timer < 2.2){
                drawImage(fadeArray[1], 0,0,800,600,g);
            }
            if(timer > 2.2 && timer < 2.3){
                drawImage(fadeArray[2], 0,0,800,600,g);
            }
            if(timer > 2.3 && timer < 2.4){
                drawImage(fadeArray[3], 0,0,800,600,g);
            }
            if(timer > 2.4 && timer < 2.5){
                drawImage(fadeArray[4], 0,0,800,600,g);
            }
            if(timer > 2.5 && timer < 2.6){
                drawImage(fadeArray[5], 0,0,800,600,g);
            }
            if(timer > 2.6 && timer < 2.7){
                drawImage(fadeArray[6], 0,0,800,600,g);
            }
            if(timer > 2.7 && timer < 2.8){
                drawImage(fadeArray[7], 0,0,800,600,g);
            }
            if(timer > 2.8 && timer < 2.9){
                drawImage(fadeArray[8], 0,0,800,600,g);
            }
            if(timer > 2.9 && timer < 3){
                drawImage(fadeArray[9], 0,0,800,600,g);
            }
            if(timer > 3 && timer < 4){
                drawImage(fadeArray[9], 0,0,800,600,g);
                change = true;
            }
            if(timer > 4 && timer < 4.1){
                drawImage(fadeArray[9], 0,0,800,600,g);
            }
            if(timer > 4.1 && timer < 4.2){
                drawImage(fadeArray[8], 0,0,800,600,g);
            }
            if(timer > 4.2 && timer < 4.3){
                drawImage(fadeArray[7], 0,0,800,600,g);
            }
            if(timer > 4.3 && timer < 4.4){
                drawImage(fadeArray[6], 0,0,800,600,g);
            }
            if(timer > 4.4 && timer < 4.5){
                drawImage(fadeArray[5], 0,0,800,600,g);
            }
            if(timer > 4.5 && timer < 4.6){
                drawImage(fadeArray[4], 0,0,800,600,g);
            }
            if(timer > 4.6 && timer < 4.7){
                drawImage(fadeArray[3], 0,0,800,600,g);
            }
            if(timer > 4.7 && timer < 4.8){
                drawImage(fadeArray[2], 0,0,800,600,g);
            }
            if(timer > 4.8 && timer < 4.9){
                drawImage(fadeArray[1], 0,0,800,600,g);
            }
            if(timer > 4.9 && timer < 5){
                drawImage(fadeArray[0], 0,0,800,600,g);
            }
            if(timer > 5 && timer < 6){
                drawImage(WizardBad, 400, 100, 50, 70, g);

                drawImage(smokeArray[animationChange%34], 250, 200, g);
                drawImage(smokeArray[animationChange%34], 350, 265, g);
                drawImage(WizardSpin[animationChange % 4], 300, 250, 50, 70, g);
                drawImage(BjarneSpin[animationChange % 4], 400, 315, 50, 70, g);
            }
            if(timer > 6 && timer < 15){
                drawImage(WizardBad, 400, 100, 50, 70, g);
                drawImage(WizardSpin[2], 300, 250, 50, 70, g);
                drawImage(BjarneSpin[2], 400, 315, 50, 70, g);
            }
            if(timer > 6 && timer < 9){
                drawImage(dialogueBack, 90, 400, 620, 165, g);
                changeColor(white, g);
                drawText(110, 425, "Therox: ", "Times New Roman", 20, g);
                drawText(110, 450, "WHAT!? How on earth- Nevermind that, you made a grave mistake ", "Times New Roman", 20, g);
                drawText(110, 475, "coming here!", "Times New Roman", 20, g);
                drawText(110, 500, "", "Times New Roman", 20, g);
            }
            if(timer > 9 && timer < 12){
                drawImage(dialogueBack, 90, 400, 620, 165, g);
                changeColor(white, g);
                drawText(110, 425, "Sevar: ", "Times New Roman", 20, g);
                drawText(110, 450, "HA! We're ready for you now Therox! This is it, you're done!", "Times New Roman", 20, g);
                drawText(110, 475, "", "Times New Roman", 20, g);
                drawText(110, 500, "", "Times New Roman", 20, g);
            }
            if(timer > 12 && timer < 15){
                //Insert fireball animation here
            }
            if(timer > 15 && timer < 50){
                drawImage(WizardBad, 400, 100, 50, 70, g);
                drawImage(BjarneSpin[2], 400, 315, 50, 70, g);
            }
            if(timer > 15 && timer < 18){
                drawImage(dialogueBack, 90, 400, 620, 165, g);
                changeColor(white, g);
                drawText(110, 425, "Bjarne: ", "Times New Roman", 20, g);
                drawText(110, 450, "SEVARRRRR NOOOOOO! Therox! You did this, you'll pay!", "Times New Roman", 20, g);
                drawText(110, 475, "", "Times New Roman", 20, g);
                drawText(110, 500, "", "Times New Roman", 20, g);
            }
            if(timer > 18){
                changeColor(white, g);
                drawText(250, 450, "- Press <SPACE> to initiate battle -",  "New Roman Times", 20, g);
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