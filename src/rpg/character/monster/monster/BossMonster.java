package rpg.character.monster.monster;

import rpg.character.AbstractParty;
import rpg.character.monster.Monster;
import rpg.character.Specialist;
public abstract class BossMonster extends Monster implements Specialist{
    public BossMonster(String name, int hp, int attack){
        super(name, hp, attack);
    }

    @Override
    public abstract boolean special(AbstractParty targets);
}
