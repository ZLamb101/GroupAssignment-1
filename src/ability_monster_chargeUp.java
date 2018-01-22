public class ability_monster_chargeUp extends Ability {

    public ability_monster_chargeUp(){
        this.setName("Charge Up!");
        this.setSpeed(0);
        this.setAttack(0);
        this.setDefense(0);
        this.setLuck(0);
        this.setStrength(0);
        this.setMagic(true);
        this.setEnergyCost(-1);
        this.setActive(true);
        this.setType(AbilityType.buff);
        this.setDisplayString("The Giant is gaining energy!");
    }

    @Override
    public Ability use(Statblock user){
        user.setEnergy(user.getEnergy() + 2);
        if(user.getEnergy() > 5){
           user.setEnergy(5);
       }
       return this;
    }

}