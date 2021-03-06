import java.awt.*;

public class quest_TheRoadToRiches extends Quest {





    quest_TheRoadToRiches(){
        setQuestName("The Road To Riches");
        state = questState.preQuest;
        displayTimer = 0;
        displayDuration = 5;
    }


    @Override
    public boolean updateRewardDisplay(double dt) {
        if(displayReward = super.updateRewardDisplay(dt)) {
// Bronze sword
         return true;
        }
       displayTimer = 0;
        return false;
    }

    public void giveReward(Character playerMan){
        item_Equipment bronzeSword = new item_Equipment("Bronze Sword", 1, 0, 0, 1, 0, Item.Slot.weapon, "Durable and strong", 50, 300);
        playerMan.addItemToInventory(bronzeSword); //T1 Sword
        playerMan.checkLevelUp();
    }



    public void drawQuestReward(Graphics2D g){
        if(displayReward){
            super.drawQuestReward(g);
            changeColor(white, g);
            drawBoldText(310, 40, "Quest Reward", "Felix Titling", 18, g);
          //  changeColor(purple, g);
            drawBoldText(340, 70, " +250 EXP", "Felix Titling", 16, g);
        }




    }



    public void drawQuest(Graphics2D g){
        changeColor(black, g);
        if(getState() == questState.preQuest) {
            drawText(40, 460, "Speak to the Blacksmith", "Arial", 20, g);

        }
        if(getState() == questState.inQuest) {
            drawText(40, 460, "Go talk to Link", "Arial", 20, g);
        }


    }





}