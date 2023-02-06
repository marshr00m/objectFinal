package rpg;

import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.MonsterParty;

public class BattleField {
    public static String battle(HeroParty heros, MonsterParty monsters) {
        // System.out.println("モンスターと遭遇した");
        for (AbstractCharacter hero : heros.getMembers()){
            hero.init();
        }
        for (AbstractCharacter m : monsters.getMembers()) {
            System.out.print(m.getName() + " ");
        }
        System.out.println("があらわれた");
        while (true) {
            System.out.println("勇者のターン");
            heros.printPartyStatus();
            String flg = heros.turn(monsters);
            if(flg.equals("BEAT")){
                return "WIN";
            }else if(flg.equals("ESCAPE")){
                return "ESCAPE";
            }
            System.out.println("モンスターのターン");
            flg = monsters.turn(heros);
            if(flg.equals("BEAT")){
                return "LOSE";
            }
        }
    }
}
