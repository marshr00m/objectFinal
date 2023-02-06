package rpg.character.hero.job;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Warrior extends AbstractSuperHero{
    public Warrior(String name){
        super(name, 100, 30);
    }
    @Override
    public boolean special(AbstractParty targets) {
        AbstractCharacter targetCharacter = selectTarget(targets);
        if (targetCharacter.isDead()) {
            return false;
        }
        Random random = new Random();
        int randomAttack = 0;
        int damage;
        if(targetCharacter.getName().equals("ドラゴン")){
            randomAttack = random.nextInt(attack) +attack + 30;
            damage = targetCharacter.gotDamage(randomAttack);
        } else {
            randomAttack = random.nextInt(attack) + attack;
            damage = targetCharacter.gotDamage(randomAttack);
        }
        System.out.println(getName() + "のドラゴンキック，" + targetCharacter.getName() + "に" + damage + "のダメージ");
        return true;
    }
}
