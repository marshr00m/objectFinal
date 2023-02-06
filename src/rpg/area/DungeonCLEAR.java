package rpg.area;

import rpg.character.AbstractCharacter;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.monster.Dragon;

public class DungeonCLEAR extends Dungeon{
    public Area access(HeroParty party){
        System.out.println("ゲームクリア！！");
        try {
            Thread.sleep(1000);
            System.out.println("Cast");
            Thread.sleep(1000);

            int i = 0;
            for(AbstractCharacter c : party.getMembers()){
                Hero hero = (Hero) c;
                System.out.println("ヒーロー"+ i +": " + c.getName() + "(" + hero.getJob() + ")");
                Thread.sleep(1000);
                i++;
            }

            System.out.print("お  ");
            Thread.sleep(1000);
            System.out.print("わ  ");
            Thread.sleep(1000);
            System.out.println("り  ");
            System.exit(0);

        } catch (InterruptedException e) {
            throw new Error();
        }
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

