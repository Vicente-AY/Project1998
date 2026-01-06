package Game;
import Utils.*;
import Characters.*;
import Items.*;

import java.util.Random;
import java.util.Scanner;

public class Combat {
    PlayerTurn pTurn = new PlayerTurn();
    EnemyGenerator gen = new EnemyGenerator();
    Enemy currentEnemy ;
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    int turn = 0;




    public void combatStage(Player contestant){
        currentEnemy = gen.generateEnemy();

        while(contestant.getAlive() == true && currentEnemy.getAlive() == true){
            contestant.setDefending(false);
            if(turn > 0){
                System.out.println("Turn: " + turn);
            }
            System.out.println("Player: " + contestant.getName() + " " + contestant.getHealth() + "/" + contestant.getMaxHealth() + " HP");
            System.out.println("Current enemy: " + currentEnemy.getName() + " " + currentEnemy.getHealth() + "/" + currentEnemy.getMaxHealth() + " HP");
            System.out.println("Choose your action");
            System.out.println("1. Attack | 2. Defend | 3. Use Consumable | 4. Run Away");
            int action = sc.nextInt();
            switch (action){
                case 1:
                    pTurn.playerAttack(contestant, currentEnemy);
                    if(currentEnemy.getAlive() == false){
                        System.out.println("YOU WIN THE BATTLE!");
                        return;
                    }
                    turn++;
                    break;
                case 2:
                    pTurn.playerDefend(contestant);
                    turn++;
                    break;
                case 3:
                    pTurn.playerConsumableUse(contestant, currentEnemy);
                    turn++;
                    break;
            }
        }
    }
}