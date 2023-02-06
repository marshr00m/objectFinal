package rpg.area;

import rpg.BattleField;
import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.BossMonster;

import java.util.Random;

public abstract class Dungeon extends Area{
    protected int floorNum;
    protected int encountCounter;

    protected abstract Monster nextMonster(int i);
    protected abstract Monster nextBoss();

    protected abstract Area nextArea();

    public Area access(HeroParty party){
        this.printArea();
        party.printPartyStatus();
        while (true) {
            System.out.println("どうしますか");
            System.out.println("1:探索する　2：はじまりの町へ戻る");
            int nextMove = ScanCommand.scan();
            if (nextMove == 1) {
                String result = this.explore(party);
                if (result.equals("WIN")) {
                    Area nextarea = nextArea();
                    nextarea.access(party);
                } else if (result.equals("LOSE")) {
                    DungeonGAMEOVER GAMEOVER =  new DungeonGAMEOVER();
                    GAMEOVER.access(party);
                }
            } else if (nextMove == 2) {
                Town town = new Town();
                town.access(party);
            }
        }
    }

    public String explore(HeroParty party){
        String result;
        while (true) {
            this.printExplore();
            Random random = new Random();
            int randomNum = random.nextInt(5);
            if ((randomNum == 0 && this.encountCounter > 1) || this.encountCounter > 3) {
                result = this.encountBoss(party);
                if(result.equals("ESCAPE")){
                    continue;
                }
                return result;
            } else if (1 <= randomNum && randomNum <= 3) {
                result = this.encountMob(party);
                if(result.equals("LOSE")){
                    return result;
                }
                this.encountCounter += 1;
            }
        }
    }

    public void printArea() {
        System.out.println("現在の場所は" + name + "です．");
    }

    private String encountMob(HeroParty party){
        Random random = new Random();
		int numOfMonster = random.nextInt(3) + 1;
        Monster[] monsters = new Monster[numOfMonster];
		for (int i = 0; i < numOfMonster; i++) {
            monsters[i] = this.nextMonster(i);
        }
        MonsterParty m = new MonsterParty(monsters);
        String result = BattleField.battle(party, m);
        this.printBattleResult(result,"戦い");
        return result;
    }

    private String encountBoss(HeroParty party){
        System.out.println("ボスモンスターと遭遇した");
        AbstractCharacter[] boss = new AbstractCharacter[1];
        boss[0] = this.nextBoss();
        MonsterParty bosses = new MonsterParty(boss);
        String result = BattleField.battle(party, bosses);
        this.printBattleResult(result, boss[0].getName());
        return result;
    }

    private void printBattleResult(String result, String bossName){
        if (result.equals("WIN")) {
            System.out.println("勇者たちは"+bossName+"に勝利した");
        } else if(result.equals("LOSE")){
            System.out.println("勇者たちは"+bossName+"に敗北した");
        } else if(result.equals("ESCAPE")){
            System.out.println("勇者たちは"+bossName+"から逃げ出した");
        }
    }

    private void printExplore() {
        System.out.println("トコトコ");
        for (int i = 0; i < 3; i++) {
            System.out.print("．");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
