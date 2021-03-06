import java.awt.*;

public class monster_Wolf extends Monster {

    public monster_Wolf() {
        this.init();
    }

    public void init(){
        Ability [] temp;
        temp= new Ability[4];
        for(int i=0; i<4; i++){
            temp[i]=new Ability();
        }
        setAttack(4);
        setDefense(2);
        setLuck(0);
        setSpeed(2);
        setStrength(2);
        setXPGain(150);
        setGoldMin(80);
        setGoldMax(100);
        setCurrentHP(90);
        setMaxHP(90);
        setLevel(2);
        setAlive(true);
        setName("Wolf");
        setEnergy(0);

        Image sprite = loadImage("Image/monster_Wolf.png");
        setSprite(sprite);
        setSpriteWidth(120);
        setSpriteHeight(120);

        setUpAbilityNumberI(temp, 0, "Bite", 0, 0, 0, 0, 0, false, -1,"", true, Ability.AbilityType.damage, "");
        temp[1] = new ability_monster_roar();
        setUpAbilityNumberI(temp, 2, "Rend", 3, 4, 0, 0, 4, false, 4, "", true, Ability.AbilityType.damage, "");
        temp[3] = new ability_monster_rabidFang();
        this.setAbilities(temp);
    }

    @Override
    public Item dropLoot(){
        Item newItem = new Item();
        return newItem;
    }

    @Override
    public Ability moveChoice() {
        int num=(int)(Math.random()*100);
        Ability [] abilities = this.getAbilities();
        if(this.getCurrentHP()>0.8*this.getMaxHP()){//< If greater than 80% hp
            if(this.getEnergy()>=4){
                if(num>90){
                    return abilities[2]; //< Use Rend
                } else if (num>70){
                    return abilities[1]; //< Use Roar
                } else if(num>50){
                    return abilities[3]; //< Use Rabid Fang
                } else{
                    return abilities[0]; //< Use Basic
                }
            } else if(this.getEnergy()>=2){
                if(num>80){
                    return abilities[1]; //< Use Roar
                } else if(num >50){
                    return abilities[3]; //< Use Rabid Fang
                } else{
                    return abilities[0]; //< Use Basic
                }
            } else{
                return abilities[0]; //< Use Basic
            }
        } else if(this.getCurrentHP()>0.3*this.getMaxHP()){//< If greater than 30% hp
            if(this.getEnergy()>=4){
                if(num>70){
                    return abilities[2]; //< Use Rend
                } else if (num>50){
                    return abilities[1]; //< Use Roar
                } else if(num>30){
                    return abilities[3]; //< Use Rabid Fang
                } else{
                    return abilities[0]; //< Use Basic
                }
            } else if(this.getEnergy()>=2){
                if(num>70){
                    return abilities[1]; //< Use Roar
                } else{
                    return abilities[0]; //< Use Basic
                }
            } else{
                return abilities[0]; //< Use Basic
            }
        } else{
            if(this.getEnergy()>=4){
                if(num>40){
                    return abilities[2]; //< Use Rend
                } else if (num>30){
                    return abilities[3]; //< Use Rabid Fang
                } else{
                    return abilities[0]; //< Use Basic
                }
            } else if(this.getEnergy()>=2){
                if(num>90){
                    return abilities[3]; //< Use Rabid Fang
                } else{
                    return abilities[0]; //< Use Basic
                }
            } else{
                return abilities[0]; //< Use Basic
            }
        }
    }
}
