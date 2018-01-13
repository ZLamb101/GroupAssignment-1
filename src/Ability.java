public class Ability {

    enum AbilityType{buff, damage, curse, status};

    // Variables for accessing
    private boolean isMagic;
    private int lastDamage;
    private boolean lastHit;
    private int lastStatusDuration;
    private boolean lastCrit;
    private String lastStatus;
    private String lastAttack;
    private boolean isActive;
    private AbilityType type;

    // Variables
    private String name;
    private String toolTip;
    private int attackBonus;
    private int speedBonus;
    private int defenseBonus;
    private int strengthBonus;
    private int luckBonus;
    private int energyCost;

    private int attack;
    private int speed;
    private int defense;
    private int strength;
    private int luck;

    // Getters and setters


    public AbilityType getType() {
        return type;
    }

    public void setType(AbilityType type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getToolTip() {
        return toolTip;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }

    public boolean isMagic() {
        return isMagic;
    }

    public void setMagic(boolean magic) {
        isMagic = magic;
    }

    public int getLastDamage() {
        return lastDamage;
    }

    public void setLastDamage(int lastDamage) {
        this.lastDamage = lastDamage;
    }

    public boolean isLastHit() {
        return lastHit;
    }

    public void setLastHit(boolean lastHit) {
        this.lastHit = lastHit;
    }

    public int getLastStatusDuration() {
        return lastStatusDuration;
    }

    public void setLastStatusDuration(int lastStatusDuration) {
        this.lastStatusDuration = lastStatusDuration;
    }

    public boolean isLastCrit() {
        return lastCrit;
    }

    public void setLastCrit(boolean lastCrit) {
        this.lastCrit = lastCrit;
    }

    public String getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }

    public String getLastAttack() {
        return lastAttack;
    }

    public void setLastAttack(String lastAttack) {
        this.lastAttack = lastAttack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getSpeedBonus() {
        return speedBonus;
    }

    public void setSpeedBonus(int speedBonus) {
        speedBonus = speedBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public int getLuckBonus() {
        return luckBonus;
    }

    public void setLuckBonus(int luckBonus) {
        this.luckBonus = luckBonus;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }


    public Ability use(Statblock user){
       setAttackBonus(user.getAttackBonus()+user.getAttack()+user.getEquipAttackBonus());
       setDefenseBonus(user.getDefenseBonus()+user.getDefense()+user.getEquipDefenseBonus());
       setStrengthBonus(user.getStrengthBonus()+user.getStrength()+user.getEquipStrengthBonus());
       setSpeedBonus(user.getSpeedBonus()+user.getSpeed()+user.getEquipSpeedBonus());
       setLuckBonus(user.getLuckBonus()+user.getLuck()+user.getEquipLuckBonus());
       lastDamage=attackLoop(user);
       //user.setEnergy(user.getEnergy()-energyCost);
       lastAttack=name;
       return this;
    }


    public int attackLoop(Statblock user) {
        int damage = 0;
        if (makeAttack(user)) {
            damage = this.dealDamage(user);
            return damage;
        } else {
            return damage;
        }
    }

    public boolean makeAttack(Statblock user){
        if(isMagic){
            lastHit=true;
            return true;
        }
        double hitChance=10+attack+attackBonus+speed+speedBonus;
        double successCounter=Math.random()*user.getLevel()*10;
        if (hitChance>successCounter){
            lastHit=true;
            return true;
        } else {
            lastHit=false;
            return false;
        }
    }

    public int dealDamage(Statblock user){
        int damage =(attack+attackBonus)/2;
        damage += (strength+strengthBonus)+(Math.random()*15)+15;
        if(user.getLevel()>1) {
            damage *= (user.getLevel() / 2);
        }
        int critChance = getLuck()+luckBonus+(int)(Math.random()*50);
        if(isMagic){
            lastCrit=false;
            return damage;
        }
        if(critChance>50){
            damage*=2;
            lastCrit=true;
            return damage;
        } else {
            lastCrit=false;
            return damage;
        }
    }
}
