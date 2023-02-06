package rpg.character;

import rpg.character.hero.HeroParty;

public abstract class AbstractParty {
    private AbstractCharacter[] members;

    protected abstract boolean isEscapeAll();

    public AbstractParty(AbstractCharacter[] members){
        this.members = members;
    }

    public boolean isAllDead() {
        for (AbstractCharacter member : members) {
            if (!member.isDead()) {
                return false;
            }
        }
        return true;
    }

    public String turn(AbstractParty enemies) {
        for(AbstractCharacter member : members){
            if (!member.isDead() && !member.isEscaped()) {
                member.command(this, enemies);
                if (enemies.isAllDead()) {
                    return "BEAT";
                }
                if (enemies.isEscapeAll()) {
                    return "ESCAPE";
                }
            }
        }
        return "CONTINUE";
    }

    public AbstractCharacter[] getMembers(){
        return members;
    }
}
