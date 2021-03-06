public class item_soulStone extends Item {

    public item_soulStone() {
        this.setNumericValue(3);
        this.setEquippable(false);
        this.setSlot(Slot.bag);
        this.setCounter(1);
        this.setName("Soul Stone");
        this.setTooltip("Grants 3 energy");
        this.setUseableOustideCombat(false);
        this.setSellPrice(140);
        this.setBuyPrice(1050);
    }

    @Override
    public void use(Character user){
        user.setEnergy(user.getEnergy()+3);
        if(user.getEnergy()>5){
            user.setEnergy(5);
        }
        this.setDisplayString(user.getName() + " gained " + this.getNumericValue() + " energy!");
        super.use(user);
    }
}