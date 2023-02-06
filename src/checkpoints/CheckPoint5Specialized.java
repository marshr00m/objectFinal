package checkpoints;

import rpg.BattleField;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Warrior;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.Dragon;
import rpg.character.monster.monster.BabyDragon;

public class CheckPoint5Specialized {

	public static void main(String[] args) {
		// 勇者パーティ作成
		Hero[] heros = {
				new Warrior("a1"),
				new Warrior("a2"),
				new Warrior("a3")	
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
		// 必殺技が使えるようになっていることを確認
		BattleField bf = new BattleField();
		String result = bf.battle(hpty, mpty);
		if (result.equals("WIN")) {
			System.out.println("ヒーローたちは勝利した");
		} else if (result.equals("LOSE")) {
			System.out.println("ヒーローたちは敗北した");
		} else {
			System.out.println("ヒーローたちは逃げ出した");
		}
		
		// ヒーローたちを回復
		hpty.rest();
		
		// ボスモンスターを用意
		Monster bm[] = {
				new Dragon()
		};
		MonsterParty bmpty = new MonsterParty(bm);
		
		// ボスモンスターとの戦闘
		String bossBattleResult = bf.battle(hpty, bmpty);
		if (bossBattleResult.equals("WIN")) {
			System.out.println("ヒーローたちは勝利した");
		} else if (bossBattleResult.equals("LOSE")) {
			System.out.println("ヒーローたちは敗北した");
		} else {
			System.out.println("ヒーローたちは逃げ出した");
		}
	}

}
