import java.awt.*;

public class quest_TheRoadToRiches extends Quest {



    boolean displayReward;

    quest_TheRoadToRiches(){
        setQuestName("The Road To Riches");
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {

         return true;
        }
       displayTimer = 0;
        return false;
    }

    public void drawQuest(Graphics2D g){
        if(getState() == questState.preQuest) {
            changeColor(white, g);
            drawText(450, 30, "Speak to the Blacksmith", "Arial", 30, g);
            if(displayReward){
                changeColor(white, g);
                drawBoldText(230, 300, "Quest Reward:", "Arial", 20, g);
                changeColor(purple, g);
                drawBoldText(360, 300, " +250 EXP", "Arial", 20, g);
            }
        }
        if(getState() == questState.inQuest) {
            changeColor(white, g);
            drawText(510, 30, "Go Talk to Link", "Arial", 30, g);
        }
        if(getState() == questState.completedQuest) {
            changeColor(white, g);
            drawText(510, 30, "Return to Sevar", "Arial", 30, g);
        }

    }





}