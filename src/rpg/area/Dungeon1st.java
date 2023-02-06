package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.BabyDragon;
import rpg.character.monster.monster.Dragon;

public class Dungeon1st extends Dungeon{
    public Dungeon1st(){
        super.name = "ドラゴンの巣窟";
        int floorNum = 1;
        int encountCounter = 0;
    }

    protected Monster nextMonster(int i){
        return new BabyDragon(i);
    }
    protected Monster nextBoss(){
        return new Dragon();
    }

    protected Area nextArea(){
        return new Dungeon2nd();
    }
}
