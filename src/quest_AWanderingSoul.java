
import java.awt.*;

public class quest_AWanderingSoul extends Quest {


    quest_AWanderingSoul(){


        collectableState = new boolean[1];
        for(int i = 0; i < 1;i++){
            collectableState[i] = false;
        }
        numOfCollectables = 0;
        totalCollectables = 1;

        setQuestName("A Wandering Soul");
        state = questState.preQuest;
        displayReward = true;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {
            // 1500exp
            // 1500gold
            return true;
        }
        displayTimer = 0;
        return false;
    }

    public void giveReward(Character playerMan){
        playerMan.setXPTotal(playerMan.getXPTotal() + 1500);
        playerMan.setGpTotal(playerMan.getGpTotal() + 1500);
        playerMan.checkLevelUp();
    }

    public void drawQuestReward(Graphics2D g){
        if(displayReward){
            super.drawQuestReward(g);
            changeColor(white, g);
            drawBoldText(310, 20, "Quest Reward", "Felix Titling", 18, g);
            //  changeColor(purple, g);
            drawBoldText(310, 40, "+200 Gold", "Felix Titling", 16, g);
            drawBoldText(310, 60, "+1000 EXP", "Felix Titling", 16, g);
            drawBoldText(310, 80, "New Items in Store", "Felix Titling", 14, g);
        }
    }

    public void drawQuest(Graphics2D g){
        changeColor(black, g);
        if(getState() == questState.preQuest) {
            drawText(40, 460, "Find Dijkstra", "Arial", 20, g);

        }
        if(getState() == questState.inQuest){
            drawText(40, 460, "Find the painting in the church", "Arial", 20, g);
        }
        if(getState() == questState.completedQuest){
            drawText(40, 460, "Go to Camrath", "Arial", 20, g);
        }
        if(getState() == questState.extraQuest){
            drawText(40, 460, "Return to Sevar", "Arial", 20, g);
        }
    }
}
