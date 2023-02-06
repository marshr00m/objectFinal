package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.hero.HeroParty;

import java.util.Random;

public class Monster extends AbstractCharacter {
    public Monster(String name, int hp, int attack){
        super(name, hp, attack);
    }

    @Override
    protected void command(AbstractParty allies, AbstractParty enemies) {
        if (!this.isDead()) {
            System.out.println(this.getName() + "の行動");
            Random random = new Random();
            int command = random.nextInt(5);
            if (0 <= command && command <= 3) {
                while (true) {
                    if (attack(enemies)) {
                        break;
                    }
                }
            } else {
                System.out.println(this.getName() + "はボーっとしている");
            }
        }
    }

    protected AbstractCharacter selectTarget(AbstractParty targets) {
        Random random = new Random();
        int target = random.nextInt(3);
        return targets.getMembers()[target];
    }
}
