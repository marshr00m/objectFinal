package checkpoints;

import rpg.BattleField;
//import rpg.area.*;
import rpg.character.AbstractCharacter;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
//import rpg.character.hero.job.Warrior;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.BabyDragon;

public class CheckPoint4Battle {

	public static void main(String[] args) {
		// 勇者パーティ作成
		Hero heros[] = {
				new Hero("a1", 100, 30),
				new Hero("a2", 100, 30),
				new Hero("a3", 100, 30)	
		};
		HeroParty hpty = new HeroParty(heros);
		
		// モンスターパーティ作成
		Monster ms[] = {
				new BabyDragon(0),
				new BabyDragon(1),
				new BabyDragon(2)
		};
		MonsterParty mpty = new MonsterParty(ms);
		
		// ヒーロパーティーとモンスターパーティの戦闘
		BattleField bf = new BattleField();
		String result = bf.battle(hpty, mpty);
		if (result.equals("WIN")) {
			System.out.println("ヒーローたちは勝利した");
		} else if (result.equals("LOSE")) {
			System.out.println("ヒーローたちは敗北した");
		} else {
			System.out.println("ヒーローたちは逃げ出した");
		}
	}

}
