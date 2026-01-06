package Game;
import Characters.*;
import Items.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlayerTurn {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);


    public void playerAttack(Player contestant, Enemy currentEnemy){
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
        if(currentEnemy.isDefending()){
            enemyDefence *= 1.5;
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
        if(enemyHealth <= 0){
            currentEnemy.setHealth(0);
            currentEnemy.die();
        }

        else {
            currentEnemy.setHealth(enemyHealth);
        }
    }

    public void playerDefend(Player contestant){
        System.out.println(contestant.getName() + " is in a defense position.");
        contestant.setDefending(true);
    }

    public void playerConsumableUse(Player contestant, Enemy currentEnemy){
        ArrayList<Consumible> usables = new ArrayList<>();
        System.out.println("Consumable inventory");
        if(contestant.getInventory().isEmpty()){
            System.out.println("Empty Inventory");
            return;
        }
        Consumible selectedConsumible;
        for(Item item : contestant.getInventory()) {
            if (item instanceof Consumible) {
                Consumible usable = (Consumible) item;
                usables.add(usable);
            }
        }
        if(usables.isEmpty()){
            System.out.println("No Consumibles in Inventory");
            return;
        }
        System.out.println("Select a Consumible: ");
        for(int i = 0; i < usables.size(); i++){
            System.out.println("Usable " + (i + 1) + usables.get(i).getName()
                                + " Power: " + usables.get(i).getPower()
                                + " Uses: " + usables.get(i).getDurability());
        }
        int option = scan.nextInt();
        scan.nextLine();
        selectedConsumible = usables.get(option -1);
        switch(selectedConsumible.getType()){
            case Type.Heal:
                int currentHealth = contestant.getHealth();
                currentHealth += selectedConsumible.getPower();
                if(currentHealth > contestant.getMaxHealth()){
                    currentHealth = contestant.getMaxHealth();
                }
                contestant.setHealth(currentHealth);
                System.out.println("You healed " + selectedConsumible.getPower());
                break;
            case Type.Damage:
                int enemyHealth = currentEnemy.getHealth();
                enemyHealth  -= selectedConsumible.getPower();
                if(enemyHealth <= 0){
                    currentEnemy.setHealth(0);
                    currentEnemy.die();
                }
                else{
                    currentEnemy.setHealth(enemyHealth);
                }
                System.out.println("You dealt " + selectedConsumible.getPower() + " Damage");
                break;
        }
        selectedConsumible.setDurability(selectedConsumible.getDurability() -1);
        if(selectedConsumible.getDurability() <= 0){
            contestant.getInventory().remove(selectedConsumible);
        }
    }
}



