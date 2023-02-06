package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class MonsterParty extends AbstractParty {
    public MonsterParty(AbstractCharacter[] monsteres){
        super(monsteres);
    }

    @Override
    public boolean isEscapeAll(){
        for (AbstractCharacter monster : this.getMembers()) {
            if (!monster.isEscaped()) {
                return false;
            }
        }
        return true;
    }
}
