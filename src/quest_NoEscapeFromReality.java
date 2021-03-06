
import java.awt.*;

public class quest_NoEscapeFromReality extends Quest {

    quest_NoEscapeFromReality(){


        collectableState = new boolean[1];
        for(int i = 0; i < 1;i++){
            collectableState[i] = false;
        }
        numOfCollectables = 0;
        totalCollectables = 1;

        setQuestName("No Escape From Reality");
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {
            //1000exp
            // 150gold
            return true;
        }
        displayTimer = 0;
        return false;
    }
    public void giveReward(Character playerMan){
        playerMan.setXPTotal(playerMan.getXPTotal() + 1000);
        playerMan.setGpTotal(playerMan.getGpTotal() + 200);
        playerMan.checkLevelUp();
    }

    public void drawQuestReward(Graphics2D g){
        if(displayReward){
            super.drawQuestReward(g);
            changeColor(white, g);
            drawBoldText(310, 40, "Quest Reward", "Felix Titling", 18, g);
            //  changeColor(purple, g);
            drawBoldText(310, 60, "+ Mega Potion", "Felix Titling", 16, g);
            drawBoldText(330, 80, "+500 EXP", "Felix Titling", 16, g);
        }
    }

    public void drawQuest(Graphics2D g){
        changeColor(black, g);

        if(getState() == questState.preQuest) {
            drawText(40, 460, "Go find the holy symbol", "Arial", 20, g);

        }
        if(getState() == questState.inQuest){
            drawText(40, 460, "Return to Sevar", "Arial", 20, g);
        }
        if(getState() == questState.completedQuest){
            drawText(40, 460, "Head to the church and find Sally", "Arial", 20, g);
        }
        if(getState() == questState.extraQuest){
            drawText(40, 460, "Head back to town", "Arial", 20, g);
        }
    }
}
