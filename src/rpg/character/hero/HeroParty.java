package rpg.character.hero;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class HeroParty extends AbstractParty{
    public HeroParty(AbstractCharacter[] heros){
        super(heros);
    }

    public void rest(){
        for(AbstractCharacter hero : this.getMembers()){
            hero.gotHeal(hero.getMaxHp());
        }
    }

    public void printPartyStatus(){
        for(AbstractCharacter c : this.getMembers()){
            Hero hero = (Hero) c;
            this.printHeroStatus(hero);
        }
    }

    private void printHeroStatus(Hero hero) {
        if (hero.getHp() > 0 && !hero.isEscaped()) {
            System.out.print(hero.getName() + "(" + hero.getJob() + "):" + hero.getHp() + " ");
        } else if (hero.getHp() <= 0){
            System.out.println(hero.getName() + "(" + hero.getJob() + "):死亡　");
        }else if (hero.isEscaped()){
            System.out.println(hero.getName() + "(" + hero.getJob() + "):逃亡　");
        }

    }

    public boolean isEscapeAll(){
        for (AbstractCharacter hero : this.getMembers()) {
            if (!hero.isEscaped()) {
                return false;
            }
        }
        return true;
    }
}
