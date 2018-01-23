import java.awt.*;
import java.awt.event.KeyEvent;

public class armorShop extends shop {

    armorShop(Character playerMan){
        super(playerMan);
        setTotalPages(2);
        setMaxIndex(17);
    }

    @Override
    public void shopInit() {
        Item[] inventory = new Item[50];
        for(int i = 0;  i < 50; i++){
            inventory[i] = new Item();
        }
        inventory[0] = new item_Equipment("Skull Cap", 0, 1, 0, 0, 0, Item.Slot.head, "Can deflect blows", 40, 290);
        inventory[1] = new item_Equipment("Worn Buckler", 0, 1, 0, 0, 0, Item.Slot.offhand, "A small buckler", 20, 200);
        inventory[2] = new item_Equipment("Shiv", 1, 0, 0, 1, 0, Item.Slot.offhand, "A twisted edge", 40, 290);
        inventory[3] = new item_Equipment("Assassin's Dagger", 3, 0, 0, 1, 0, Item.Slot.offhand, "Keen and silent", 40, 2050);
        inventory[4] = new item_Equipment("Steel Visor", 0, 2, 0, 0, 0, Item.Slot.head, "Safety is key", 240, 780);
        inventory[5] = new item_Equipment("Conical Helm", 0, 3, 0, 0, 0, Item.Slot.head, "Excellent skull protection", 340, 1980);
        inventory[6] = new item_Equipment("Great Helm", 0, 4, 0, 0, 0, Item.Slot.head, "Forged to withstand giants", 765, 3200);
        inventory[7] = new item_Equipment("Wooden Shield", 0, 2, 0, 0, 0, Item.Slot.offhand, "A lightweight shield", 120, 600);
        inventory[8] = new item_Equipment("Steel Shield", 0, 4, 1, 0, 0, Item.Slot.offhand, "An elite's shield", 1200, 2800);
        inventory[9] = new item_Equipment("Leather Boots", 0, 1, 0, 2, 0, Item.Slot.feet, "Sturdy walking boots", 10, 210);
        inventory[10] = new item_Equipment("Chain Boots", 0, 2, 0, 2, 0, Item.Slot.feet, "Light and durable", 230, 550);
        inventory[11] = new item_Equipment("Half Plate Boots", 0, 3, 0, 1, 0, Item.Slot.feet, "A guardman's pair", 415, 1890);
        inventory[12] = new item_Equipment("Full Plate Boots", 0, 4, 0, 0, 0, Item.Slot.feet, "Made for knights", 1090, 3040);
        inventory[13] = new item_Equipment("Traveller's Robe", 0, 0, 0, 0, 0, Item.Slot.chest, "For long journeys", 10, 0);
        inventory[14] = new item_Equipment("Leather Jack", 0, 1, 0, 1, 0, Item.Slot.chest, "Provides basic protection", 50, 300);
        inventory[15] = new item_Equipment("Scale Mail", 0, 2, 0, 2, 0, Item.Slot.chest, "A sturdy chestpiece", 390, 1040);
        inventory[16] = new item_Equipment("Breastplate", 0, 4, 0, 2, 0, Item.Slot.chest, "Solid and sure", 1080, 2700);
        inventory[17] = new item_Equipment("Full Platemail", 0, 8, 0, 0, 0, Item.Slot.chest, "The pinnacle of armour", 2340, 4900);
        setShopInventory(inventory);
    }

    public void updtaeShop(){
        if(getItemIndex() > getMaxIndex()){
            setItemIndex(getMaxIndex());
        }
        setScroller((getItemIndex()%10));
    }

    public void drawShop(Graphics2D g) {
        //< Set up background
        clearBackground(800, 600, g);
        changeBackgroundColor(black, g);
        drawImage(this.getShopBackground(), 0, 0, 800, 600, g);
        changeColor(black, g);
        drawBoldText(80, 60, "LINK'S ARMORY", "Felix Titling", 30, g);

        //< Draw scroller
        drawLine(70,  (this.getScroller()*45) + 140, 250, (this.getScroller()*45) + 140, 2, g);

        //< Draw page number
        drawBoldText(80, 90, "Page: " + Integer.toString(this.getPageNum()) + " / " + Integer.toString(this.getTotalPages()), "Felix Titling", 17, g);

        // Draw Items on screen
        setIncreaser(0);
        for (int i = ((getPageNum()- 1) * 10); i < (getPageNum()*10); i++) {
            if(i <= getMaxIndex()) {
                //Draw left side (Item name)
                changeColor(purple, g);
                drawBoldText(70, 130 + (this.getIncreaser() * 45), this.getShopInventory()[i].getName(), "Felix Titling", 15, g);
                this.setIncreaser(this.getIncreaser() + 1);
            }
        }

        // Draw Cursored Item

        drawBoldText(420, 65, getShopInventory()[getItemIndex()].getName(), "Felix Titling", 20, g);
        drawLine(420, 70, 620, 70, 2, g);

        changeColor(black, g);
        drawBoldText(420, 100, "ATK", "Felix Titling", 15, g);
        drawBoldText(420, 100 + 30, "DEF", "Felix Titling", 15, g);
        drawBoldText(420, 100 + 60, "STR", "Felix Titling", 15, g);
        drawBoldText(420, 100 + 90, "SPD", "Felix Titling", 15, g);
        drawBoldText(420, 100 + 120, "LUK", "Felix Titling", 15, g);

        drawBoldText(690, 100, Integer.toString(getShopInventory()[getItemIndex()].getAttack()), "Felix Titling", 18, g);
        drawBoldText(690, 100 + 30, Integer.toString(getShopInventory()[getItemIndex()].getDefense()), "Felix Titling", 18, g);
        drawBoldText(690, 100 + 60, Integer.toString(getShopInventory()[getItemIndex()].getStrength()), "Felix Titling", 18, g);
        drawBoldText(690, 100 + 90, Integer.toString(getShopInventory()[getItemIndex()].getSpeed()), "Felix Titling", 18, g);
        drawBoldText(690, 100 + 120, Integer.toString(getShopInventory()[getItemIndex()].getLuck()), "Felix Titling", 18, g);

        changeColor(purple, g);
        drawBoldText(420, 260, getShopInventory()[getItemIndex()].getSlot().name() + " ITEM", "Felix Titling", 20, g);
        changeColor(black, g);
        drawBoldText(420, 300, getShopInventory()[getItemIndex()].getTooltip() + ".", "Felix Titling", 17, g);
        changeColor(purple, g);
        drawBoldText(420, 450, "Bjarne's Gold:", "Felix Titling", 20, g );
        drawBoldText(420, 500, "PRICE:", "Felix Titling", 20, g );
        changeColor(black, g);
        drawBoldText(670, 450, Integer.toString(getPlayer1().getGpTotal()), "Felix Titling", 20, g);
        drawBoldText(670, 500, Integer.toString(getShopInventory()[getItemIndex()].getBuyPrice()), "Felix Titling", 20, g);

        // Draw extras
        drawBoldText(420, 530, "BUY ITEM [SPACE]", "Felix Titling", 15, g);
        drawBoldText(620, 530, "BACK [ESC]", "Felix Titling", 15, g);


        // Draw purchase results
        if(isPurchaseAttempt()){
            changeColor(black, g);
            drawImage(getDialougeBox(),100, 200, 600, 200, g);
            //drawSolidRectangle(100, 200, 600, 200, g);
            changeColor(white, g);
            if(isPurchaseSuccess()){
                drawBoldText(225, 280, "You bought " + getShopInventory()[getItemIndex()].getName(), "Felix Titling", 20, g) ;
                drawBoldText( 300, 320,  "for " + Integer.toString(getShopInventory()[getItemIndex()].getBuyPrice()) + " gold","Felix Titling", 20, g);
            }else{
                if(getPlayer1().isInventoryFull()) {
                    drawBoldText(225, 280, "Cannot buy " + getShopInventory()[getItemIndex()].getName() + "!", "Felix Titling", 20, g) ;
                    drawBoldText( 275, 320,  "Inventory is full!","Felix Titling", 20, g);
                } else if(getPlayer1().getGpTotal() < getShopInventory()[getItemIndex()].getBuyPrice()){
                    drawBoldText(225, 280, "Cannot buy " + getShopInventory()[getItemIndex()].getName() + "!", "Felix Titling", 20, g) ;
                    drawBoldText( 275, 320,  "Not enough gold!","Felix Titling", 20, g);
                }
            }
            drawBoldText(300, 375, "PRESS [SPACE] TO CLOSE", "Felix Titling", 10, g);
        }

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(!isPurchaseAttempt()) {
                if ((getItemIndex()% 10) != 9) {
                    setItemIndex(getItemIndex() + 1);
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(!isPurchaseAttempt()) {
                if ((getItemIndex()% 10) != 0){
                    setItemIndex(getItemIndex() - 1);
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(!isPurchaseAttempt()) {
                if (getPageNum() < getTotalPages()) {
                    setPageNum(getPageNum() + 1);
                    setItemIndex(((getPageNum() - 1) * 10));
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if(!isPurchaseAttempt()) {
                if (getPageNum() != 1) {
                    setPageNum(getPageNum() - 1);
                    setItemIndex(((getPageNum() - 1) * 10));
                }
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(!isPurchaseAttempt()) {
                this.buyItem(getItemIndex());
            } else {
                setPurchaseAttempt(false);
                setPurchaseSuccess(false);
            }
        }
    }

}