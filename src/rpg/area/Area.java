package rpg.area;

import rpg.character.hero.HeroParty;

public abstract class Area{
    protected String name;

    public abstract Area access(HeroParty party);

    public abstract void printArea();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
