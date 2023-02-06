package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.monster.BabyDragon;
import rpg.character.monster.monster.Daemon;
import rpg.character.monster.monster.Dragon;
import rpg.character.monster.monster.KingDaemon;

public class Dungeon2nd extends Dungeon{
    public Dungeon2nd(){
        super.name = "デーモンの間";
        int floorNum = 2;
        int encountCounter = 0;
    }

    protected Monster nextMonster(int i){
        return new Daemon(i);
    }
    protected Monster nextBoss(){
        return new KingDaemon();
    }

    protected Area nextArea(){
        return new DungeonCLEAR();
    }
}
