package rpg.character.hero.job;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Sorcerer extends AbstractSuperHero{
    public Sorcerer(String name){
        super(name, 100, 30);
        super.job = "魔法使い";
    }
    @Override
    public boolean special(AbstractParty allies, AbstractParty targets) {
        Random random = new Random();
        System.out.println(this.getName() + "のファイア，敵全員が炎の渦に巻き込まれた");
        for (AbstractCharacter targetCharacter : targets.getMembers()){
            if (!targetCharacter.isDead() && !targetCharacter.isEscaped()) {
                int randomAttack = random.nextInt(attack) + attack;
                int damage = targetCharacter.gotDamage(randomAttack);
                System.out.println(targetCharacter.getName()+"に" + damage + "のダメージ");
                targetCharacter.actionStatus();
            }
        }

        return true;
    }
}
