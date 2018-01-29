import java.awt.*;
import java.awt.event.KeyEvent;

public class finalCutscene extends extraFunctions{

    double timer;
    int animationChange;
    Image backgroundFight;
    Image backgroundSevar;
    Image smokeSheet;
    Image smokeArray[];
    Image spritesheet;
    Image spritesheet2;
    Image BjarneSpin[];
    Image Therox;
    Image dialogueBackSheet;
    Image dialogueBack;
    Image bloodSheet;
    Image bloodArray[];
    Image fade;
    Image fadeArray[];
    Image temp;
    boolean change;

    finalCutscene(){
        timer = 0;
        animationChange = 0;
        change = false;
        backgroundFight = loadImage("bossFight.png");
        backgroundSevar = loadImage("bossFight.png");       //PLACEHOLDER
        smokeSheet = loadImage("smoke.png");
        spritesheet = loadImage("chara1.png");
        spritesheet2 = loadImage("chara2.png");
        bloodSheet = loadImage("bloodSprite.png");
        Therox = subImage(spritesheet2, 520, 288, 52, 72);
        smokeArray = new Image[35];
        BjarneSpin = new Image[4];
        bloodArray = new Image[6];
        fade = loadImage("fade.png");
        fadeArray = new Image[10];
        dialogueBackSheet = loadImage("dialogue_boxes.png");
        dialogueBack = subImage(dialogueBackSheet,20,20,470,100);

        for(int i = 0; i < 3; i++){

        }
        for(int i = 0; i < 6; i++){
            bloodArray[i] = subImage(bloodSheet, 512 * i, 0, 512, 512);
        }

        for(int i = 0; i < 4; i++) {
            BjarneSpin[i] = subImage(spritesheet,364, (72*i),52,72);
            for (int j = 0; j < 8; j++) {
                smokeArray[(i*8)+j] = subImage(smokeSheet, j * 128, i * 128, 128, 128);
            }
        }
        smokeArray[32] = subImage(smokeSheet, 0, 512, 128,128);
        smokeArray[33] = subImage(smokeSheet, 128, 512, 128,128);
        smokeArray[34] = subImage(smokeSheet, 256, 512, 128,128);

        temp = BjarneSpin[3];
        BjarneSpin[3]= BjarneSpin[2];
        BjarneSpin[2]= temp;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 5; j++){
                fadeArray[(i*5) + j] = subImage(fade, j*160, i*120, 140, 100);
            }
        }
    }

    public void updateTimer(double dt){
        timer +=dt;
    }

    public void drawFinalCutsene(Graphics2D g){
        animationChange++;
        if(!change){
            drawImage(backgroundFight, 0, 0, g);
        } else{
            drawImage(backgroundSevar, 0, 0, g);
        }

        if(timer > 0 && timer < 3){
            drawImage(Therox, 350, 200, g);
            drawImage(BjarneSpin[4], 350, 400, g);
            drawImage(dialogueBack, 90, 400, 620, 165, g);
            changeColor(white, g);
            drawText(110, 425, "Therox:", "Times New Roman", 20, g);
            drawText(110, 450, "I-I... I can't believe it, you defeated me! Arghhhhhhhhhh", "Times New Roman", 20, g);
            drawText(110, 475, "", "Times New Roman", 20, g);
            drawText(110, 500, "", "Times New Roman", 20, g);
        }
//        if (timer > 3 && timer < 6){
//            drawImage(BjarneSpin[4], 350, 400, g);
//            drawImage(bloodArray[animationChange % 6], 350, 200, g);
//        }
//        if(timer > 6 && timer < 9){
//            drawImage(BjarneSpin[animationChange%4], 350, 400, g);
//            drawImage(smokeArray[animationChange % 35], 300, 350, g);
//        }
//        if(timer > 2 && timer < 42){
//            drawImage(fadeArray[0], 0,0,800,600,g);
//        }
//        if(timer > 2.1 && timer < 2.2){
//            drawImage(fadeArray[1], 0,0,800,600,g);
//        }
//        if(timer > 2.2 && timer < 2.3){
//            drawImage(fadeArray[2], 0,0,800,600,g);
//        }
//        if(timer > 2.3 && timer < 2.4){
//            drawImage(fadeArray[3], 0,0,800,600,g);
//        }
//        if(timer > 2.4 && timer < 2.5){
//            drawImage(fadeArray[4], 0,0,800,600,g);
//        }
//        if(timer > 2.5 && timer < 2.6){
//            drawImage(fadeArray[5], 0,0,800,600,g);
//        }
//        if(timer > 2.6 && timer < 2.7){
//            drawImage(fadeArray[6], 0,0,800,600,g);
//        }
//        if(timer > 2.7 && timer < 2.8){
//            drawImage(fadeArray[7], 0,0,800,600,g);
//        }
//        if(timer > 2.8 && timer < 2.9){
//            drawImage(fadeArray[8], 0,0,800,600,g);
//        }
//        if(timer > 2.9 && timer < 3){
//            drawImage(fadeArray[9], 0,0,800,600,g);
//        }
//        if(timer > 3 && timer < 4){
//            drawImage(fadeArray[9], 0,0,800,600,g);
//            change = true;
//        }
//        if(timer > 4 && timer < 4.1){
//            drawImage(fadeArray[9], 0,0,800,600,g);
//        }
//        if(timer > 4.1 && timer < 4.2){
//            drawImage(fadeArray[8], 0,0,800,600,g);
//        }
//        if(timer > 4.2 && timer < 4.3){
//            drawImage(fadeArray[7], 0,0,800,600,g);
//        }
//        if(timer > 4.3 && timer < 4.4){
//            drawImage(fadeArray[6], 0,0,800,600,g);
//        }
//        if(timer > 4.4 && timer < 4.5){
//            drawImage(fadeArray[5], 0,0,800,600,g);
//        }
//        if(timer > 4.5 && timer < 4.6){
//            drawImage(fadeArray[4], 0,0,800,600,g);
//        }
//        if(timer > 4.6 && timer < 4.7){
//            drawImage(fadeArray[3], 0,0,800,600,g);
//        }
//        if(timer > 4.7 && timer < 4.8){
//            drawImage(fadeArray[2], 0,0,800,600,g);
//        }
//        if(timer > 4.8 && timer < 4.9){
//            drawImage(fadeArray[1], 0,0,800,600,g);
//        }
//        if(timer > 4.9 && timer < 5){
//            drawImage(fadeArray[0], 0,0,800,600,g);
//        }

    }

    public int keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            return 1;
        }
        return 0;
    }
}
