package rpg.character.hero.job;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

import java.util.Random;

public class Priest extends AbstractSuperHero{
    public Priest(String name){
        super(name, 100, 30);
    }
    @Override
    public boolean special(AbstractParty targets) {
        Random random = new Random();
        System.out.println(this.getName() + "のヒール，味方全員が優しい光に包まれた");
        for(AbstractCharacter target : targets.getMembers()){
            if(!target.isDead()&&!target.isEscaped()){
                int randomHeal = random.nextInt(10) + 11;
                int heal = target.gotHeal(randomHeal);
                System.out.println(target.getName()+ "が" + heal + "の回復");
            }
        }
        return true;
    }
}
