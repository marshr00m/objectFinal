package rpg.character;

import java.util.Random;
import rpg.character.Specialist;

public abstract class AbstractCharacter {
    private String name;
    private int hp;
    private int maxHp;
    protected int attack;
    protected boolean escaped;

    protected abstract void command(AbstractParty allies, AbstractParty enemies);

    protected abstract AbstractCharacter selectTarget(AbstractParty targets);

    protected AbstractCharacter(String name, int hp, int attack){
        setName(name);
        setHp(hp);
        setMaxHp(hp);
        setAttack(attack);
    }

    public String getName(){
        return name;
    }

    private void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return hp;
    }

    private void setHp(int hp){
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    private void setAttack(int i){
        this.attack = i;
    }

    public int getMaxHp(){
        return maxHp;
    }

    private void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }

    public boolean isDead() {
        if (hp <= 0) {
            return true;
        }
        return false;
    }

    public boolean attack(AbstractParty enemies){
        AbstractCharacter targetCharacter = null;
        targetCharacter = this.selectTarget(enemies);
        if (targetCharacter.isDead()) {
            return false;
        }
        Random random = new Random();
        int randomAttack = random.nextInt(attack) + attack;
        int damage = targetCharacter.gotDamage(randomAttack);
        System.out.println(name + "の攻撃" + targetCharacter.name + "に" + damage + "のダメージ");
        targetCharacter.actionStatus();
        return true;
    }

    public int gotDamage(int damage) {
        if (hp - damage < 0) {
            damage = hp;
            hp = 0;
        }else{
            hp = hp - damage;
        }
        return damage;
    }

    public int gotHeal(int heal) {
        if (this.getHp() + heal < this.getMaxHp()) {
            this.setHp(this.getHp() + heal);
        } else {
            heal = this.getMaxHp()-this.getHp();
            this.setHp(this.getMaxHp());
        }
        return heal;
    }

    public boolean isEscaped() {
        return escaped;
    }

    public void init() {
        escaped = false;
    }

    public void actionStatus() {
        if(this.isDead()){
            System.out.println(name +"は倒れた");
        }
    }

}
