package Game;
import Utils.*;
import Characters.*;
import Items.*;

import java.util.Random;
import java.util.Scanner;

public class Combat {
    EnemyGenerator gen = new EnemyGenerator();
    Enemy currentEnemy ;
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);




    public void combatStage(Player contestant){
        currentEnemy = gen.generateEnemy();

        while(contestant.getAlive() == true && currentEnemy.getAlive() == true){
            System.out.println("Current enemy: " + currentEnemy.getName() + " " + currentEnemy.getHealth() + "/" + currentEnemy.getMaxHealth() + " HP");
            System.out.println("Choose your action");
            System.out.println("1. Attack | 2. Defend | 3. Use Consumable | 4. Run Away");
            String action = sc.nextLine();
            switch (action){
                case "1":
                    PlayerAttack(contestant, currentEnemy);
                    if(currentEnemy.getAlive() == false){
                        System.out.println("YOU WIN THE BATTLE!");
                        return;
                    }
                    break;
            }
        }
    }

    public void PlayerAttack(Player contestant, Enemy currentEnemy){
        int attack;
        int enemyDefence;
        int enemyHealth = currentEnemy.getHealth();
        Equipable playerWeapon = contestant.getEquipment().get(Slot.Weapon);
        int playerDice = rand.nextInt(6) + 1;
        int enemyDice = rand.nextInt(6) + 1;
        if(playerWeapon != null) {
            attack = contestant.getBaseStat() + playerWeapon.getStat() + playerDice;
        }
        else{
            attack = contestant.getBaseStat() + playerDice;
        }
        enemyDefence = currentEnemy.getBaseStat() + enemyDice;
        for(Equipable piece : currentEnemy.getEquipment().values()){
            if(piece != null){
                enemyDefence += piece.getStat();
            }
        }
        if(attack > enemyDefence){
            System.out.println("CRITICAL HIT. You made: " + attack + " Damage");
            enemyHealth -= attack;
        }
        else if(attack == enemyDefence){
            System.out.println("HIT! You made: " + attack/2 + " Damage");
            enemyHealth -= attack/2;
        }
        else{
            System.out.println("BLOCKED! You made no damage!");
            return;
        }
        if(enemyHealth < 0){
            enemyHealth = 0;
            currentEnemy.die();
        }
        else {
            currentEnemy.setHealth(enemyHealth);
        }
    }
}