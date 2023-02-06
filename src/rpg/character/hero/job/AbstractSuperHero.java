package rpg.character.hero.job;

import rpg.character.AbstractParty;
import rpg.character.hero.Hero;
import rpg.character.Specialist;


public abstract class AbstractSuperHero extends Hero implements Specialist{
    public AbstractSuperHero(String name, int hp, int attack){
        super(name, hp, attack);
    }

    @Override
    public abstract boolean special(AbstractParty targets);
}
