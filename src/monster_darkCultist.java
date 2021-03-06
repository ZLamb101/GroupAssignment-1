import java.awt.*;

public class monster_darkCultist extends Monster {

    public monster_darkCultist() {
        this.init();
    }

    public void init() {
        Ability[] temp;
        temp = new Ability[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = new Ability();
        }
        setAttack(20);
        setDefense(6);
        setLuck(4);
        setSpeed(10);
        setStrength(12);
        setXPGain(2790);
        setGoldMin(1020);
        setGoldMax(1180);
        setCurrentHP(650);
        setMaxHP(650);
        setLevel(12);
        setAlive(true);
        setName("Dark Cultist");
        setEnergy(0);
        setUpAbilityNumberI(temp, 0, "Psychic", 0, 0, 0, 0, 0, true, -1, "", true, Ability.AbilityType.damage, "");
        temp[1] =  new ability_monster_plague();
        temp[2] = new ability_monster_sacrament();
        this.setAbilities(temp);

        Image sprite = loadImage("Image/monster_darkCultist.png");
        setSprite(sprite);
        setSpriteWidth(200);
        setSpriteHeight(200);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        int num =(int)(Math.random()*100);
        if(num >90){
            newItem = new item_Antidote();
        }
        return newItem;
    }

    public Ability moveChoice(){
        int num =(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();

        if(this.getCurrentHP() > this.getMaxHP() *0.6){
            if (this.getEnergy() > 1){
                if(num > 80){
                    return abilities[1]; //< Plague
                } else {
                    return abilities[0]; //< Mind Assault
                }
            } else{
                return abilities[0]; //< Mind Assault
            }
        } else{
            if(this.getEnergy() > 4){
                return abilities[2]; //< Sacrament
            } else if (this.getEnergy() > 1){
                if(num > 70){
                    return abilities[1]; //< Plague
                } else {
                    return abilities[0]; //< Mind Assault
                }
            } else {
                return abilities[0]; //< Mind Assault
            }
        }



    }

}
