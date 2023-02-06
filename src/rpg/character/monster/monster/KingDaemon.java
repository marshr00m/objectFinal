package rpg.character.monster.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.hero.HeroParty;

import java.util.Random;

public class KingDaemon extends BossMonster{
    public KingDaemon(){
        super("デモンズゲイト", 400, 40);
    }

    @Override
    public boolean special(AbstractParty allies, AbstractParty enemies) {
        Random random = new Random();
        int randomAttack = random.nextInt(attack) + attack;
        int recover = 0;
        System.out.println(this.getName() + "のギガドレイン，勇者全員が何者かに吸い付かれた");
        for(AbstractCharacter hero : enemies.getMembers()){
            if (!hero.isDead() && !hero.isEscaped()) {
                int damage = hero.gotDamage(randomAttack);
                System.out.println(hero.getName()+"に"+damage + "のダメージ");
                hero.actionStatus();
                recover += damage;
            }
        }
        int heal = this.gotHeal(recover);
        System.out.println(this.getName() + "は" + heal + "回復した");
        return true;
    }
}
