package rpg.area;

import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;

public class DungeonGAMEOVER {
    public Area access(HeroParty party) {
        System.out.println("ゲームオーバー！！");
        System.out.println("また挑戦してね");
        System.exit(0);
        return null;
    }

    protected Monster nextMonster(int i){
        return null;
    }

    protected Monster nextBoss(){
        return null;
    }

    protected Area nextArea(){
        return null;
    }
}
