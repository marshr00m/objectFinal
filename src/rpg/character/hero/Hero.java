package rpg.character.hero;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;
import rpg.character.Specialist;
import rpg.ScanCommand;

public class Hero extends AbstractCharacter {
    protected String job;

    public Hero(String name, int hp, int attack) {
        super(name, hp, attack);
    }

    public void run() {
        System.out.println(super.getName() + "は逃げ出した");
        this.escaped = true;
    }

    public void rest() {
        this.gotHeal(super.getMaxHp());
    }

    @Override
    protected void command(AbstractParty allies, AbstractParty enemies) {
        System.out.print(this.getName() + "(" + this.getJob() + ")の行動:");
        System.out.println("1:戦う　2：逃げる　3：必殺技");
        Specialist hero = (Specialist) this;
        int command = ScanCommand.scan();
        if (command == 1) {// 戦う
            while (true) {
                if (this.attack(enemies)) {
                    break;
                }
            }
        } else if (command == 2) {// 逃げる
            this.run();
        } else if (command == 3) {// 必殺技
            while (true) {
                if (hero.special(allies, enemies)) {
                    break;
                }
            }
        } else {
            this.command(allies, enemies);
        }
    }

    public String getJob(){
        return job;
    }
    @Override
    protected AbstractCharacter selectTarget(AbstractParty targets){
        System.out.println("対象は");
        int i = 0;
        for (AbstractCharacter target : targets.getMembers()) {
            if (!target.isDead()) {
                System.out.println(i + ":" + target.getName() + " ");
            }
            i++;
        }
        System.out.println();
        int targetNo = ScanCommand.scan();
        if (targetNo < targets.getMembers().length) {
            if (!targets.getMembers()[targetNo].isDead()) {
                return targets.getMembers()[targetNo];
            } else {
                return selectTarget(targets);
            }
        } else {
            return selectTarget(targets);
        }
    }
}

