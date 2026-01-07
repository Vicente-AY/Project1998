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
        //currentEnemy = gen.generateEnemy();
        Enemy currentEnemy = new Enemy("Rata Apestosa", 25, 10, 100, 1, true);
        currentEnemy.getInventory().add(new Consumible("Poción de Vida", "Restaura salud al instante", 1, 50, Type.Heal));
        currentEnemy.getInventory().add(new Consumible("Bomba de Fuego", "Causa daño de fuego en área", 1, 60, Type.Damage));

        while(contestant.getAlive() == true && currentEnemy.getAlive() == true){
            contestant.setDefending(false);
            boolean turnFinished = false;
            while(!turnFinished) {
                if (turn > 0) {
                    System.out.println("- - - - - - - - - - - - -");
                    System.out.println("Turn: " + turn);
                }
                System.out.println("Player: " + contestant.getName() + " " + contestant.getHealth() + "/" + contestant.getMaxHealth() + " HP");
                System.out.println("Current enemy: " + currentEnemy.getName() + " " + currentEnemy.getHealth() + "/" + currentEnemy.getMaxHealth() + " HP");
                System.out.println("Choose your action");
                System.out.println("1. Attack | 2. Defend | 3. Use Consumable | 4. Run Away");
                System.out.println("- - - - Your Turn - - - -");
                int action = sc.nextInt();
                sc.nextLine();
                switch (action) {
                    case 1:
                        pTurn.playerAttack(contestant, currentEnemy);
                        if (currentEnemy.getAlive() == false) {
                            System.out.println("YOU WIN THE BATTLE!");
                            return;
                        }
                        turnFinished = true;
                        turn++;
                        break;
                    case 2:
                        pTurn.playerDefend(contestant);
                        turnFinished = true;
                        turn++;
                        break;
                    case 3:
                        boolean used = pTurn.playerConsumableUse(contestant, currentEnemy);
                        if(used){
                            if(!currentEnemy.getAlive()){
                                System.out.println("You win the battle!");
                                return;
                            }
                            turnFinished = true;
                            turn++;
                        }
                        break;
                    case 4:
                        boolean escape = pTurn.playerEscape();
                        if(escape){
                            return;
                        }
                        else{
                            turnFinished = true;
                            turn++;
                            break;
                        }

                }
            }
            EnemyTurn eTurn = new EnemyTurn();
            eTurn.enemyChoice(contestant, currentEnemy);
        }
    }
}