package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;

import java.util.Random;

public class Dragon extends BossMonster{
    public Dragon(){
        super("ドラゴン", 50, 5);
    }

    @Override
    public boolean special(AbstractParty enemies) {
        Random random = new Random();
        System.out.println(this.getName() + "の竜のいぶき，勇者全員に激しい嵐が襲いかかる");
        for(AbstractCharacter hero : enemies.getMembers()){
            if (!hero.isDead() && !hero.isEscaped()) {
                int randomAttack = random.nextInt(attack) + attack;
                int damage = hero.gotDamage(randomAttack);
                System.out.println(hero.getName() + "に" + damage + "のダメージ");
                hero.actionStatus();
            }
        }
        return true;
    }
}
