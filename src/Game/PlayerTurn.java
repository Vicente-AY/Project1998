package Game;
import Characters.*;
import Items.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlayerTurn {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    public void playerAttack(Player contestant, Enemy currentEnemy) {
        int attack;
        int enemyDefence;
        int enemyHealth = currentEnemy.getHealth();
        Equipable playerWeapon = contestant.getEquipment().get(Slot.Weapon);
        int playerDice = rand.nextInt(6) + 1;
        int enemyDice = rand.nextInt(6) + 1;
        if (playerWeapon != null) {
            attack = contestant.getBaseStat() + playerWeapon.getStat() + playerDice;
            System.out.println(contestant.getName() + " attacks with  " + playerWeapon.getName());
        }
        else {
            System.out.println(contestant.getName() + " punch " + currentEnemy.getName());
            attack = contestant.getBaseStat() + playerDice;
        }
        enemyDefence = currentEnemy.getBaseStat() + enemyDice;
        Equipable enemyWeapon  = currentEnemy.getEquipment().get(Slot.Weapon);
        for (Equipable piece : currentEnemy.getEquipment().values()) {
            if (piece != null && piece != enemyWeapon) {
                enemyDefence += piece.getStat();
            }
        }
        if(enemyWeapon != null) {
            enemyDefence -= currentEnemy.getEquipment().get(Slot.Weapon).getStat();
        }
        if (currentEnemy.isDefending()) {
            enemyDefence *= 1.5;
        }
        if (attack > enemyDefence) {
            System.out.println("CRITICAL HIT1 " + contestant.getName() + " made " + attack + " damage");
            enemyHealth -= attack;
        } else if (attack == enemyDefence) {
            System.out.println("HIT! " + contestant.getName() +  " made: " + attack / 2 + " damage");
            enemyHealth -= attack / 2;
        }
        else {
            System.out.println("BLOCKED! " + contestant.getName() + " made no damage");
            return;
        }
        if (enemyHealth <= 0) {
            currentEnemy.setHealth(0);
            currentEnemy.die();
        }
        else {
            currentEnemy.setHealth(enemyHealth);
        }
    }

    public void playerDefend(Player contestant) {
        System.out.println(contestant.getName() + " is in a defense position.");
        contestant.setDefending(true);
    }

    public boolean playerConsumableUse(Player contestant, Enemy currentEnemy) {
        ArrayList<Consumible> usables = new ArrayList<>();
        System.out.println("Consumable inventory");
        if (contestant.getInventory().isEmpty()) {
            System.out.println("Empty Inventory");
            return false;
        }
        Consumible selectedConsumible;
        for (Item item : contestant.getInventory()) {
            if (item instanceof Consumible) {
                Consumible usable = (Consumible) item;
                usables.add(usable);
            }
        }
        if (usables.isEmpty()) {
            System.out.println("No Consumibles in Inventory");
            return false;
        }
        System.out.println("Select a Consumible: ");
        System.out.println("Enter 0 to cancell");
        for (int i = 0; i < usables.size(); i++) {
            System.out.println("Usable " + (i + 1) + " " + usables.get(i).getName()
                    + " Power: " + usables.get(i).getPower()
                    + " Uses: " + usables.get(i).getDurability());
        }
        int option = scan.nextInt();
        scan.nextLine();
        if (option == 0) {
            System.out.println("Returning to combat menu");
            return false;
        }
        if (option < 0 || option > usables.size()) {
            System.out.println("Wrong choice. Cancelling");
            return false;
        }
        selectedConsumible = usables.get(option - 1);
        switch (selectedConsumible.getType()) {
            case Type.Heal:
                int currentHealth = contestant.getHealth();
                currentHealth += selectedConsumible.getPower();
                if (currentHealth > contestant.getMaxHealth()) {
                    currentHealth = contestant.getMaxHealth();
                }
                contestant.setHealth(currentHealth);
                System.out.println("You healed " + selectedConsumible.getPower() + " using " + selectedConsumible.getName());
                break;
            case Type.Damage:
                int enemyHealth = currentEnemy.getHealth();
                enemyHealth -= selectedConsumible.getPower();
                if (enemyHealth <= 0) {
                    currentEnemy.setHealth(0);
                    currentEnemy.die();
                }
                else {
                    currentEnemy.setHealth(enemyHealth);
                }
                System.out.println("You dealt " + selectedConsumible.getPower() + " damage throwing your " + selectedConsumible.getName());
                break;
        }
        selectedConsumible.setDurability(selectedConsumible.getDurability() - 1);
        if (selectedConsumible.getDurability() <= 0) {
            contestant.getInventory().remove(selectedConsumible);
        }
        return true;
    }

    public boolean playerEscape() {
        Random rand2 = new Random();
        int random = rand2.nextInt(2);
        if (random == 0) {
            System.out.println("Failed escape");
            return false;
        } else {
            {
                System.out.println("You run away from the battle");
                return true;
            }
        }
    }
}