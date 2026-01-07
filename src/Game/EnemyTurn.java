package Game;
import Characters.*;
import Items.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemyTurn {
    Random rand = new Random();

    public void enemyChoice(Player contestant, Enemy currentEnemy){
        System.out.println("- - - - Enemy Turn - - - -");
        ArrayList<Consumible> healingItems = new ArrayList<Consumible>();
        ArrayList<Consumible> throwableItems = new ArrayList<Consumible>();
        Random rand = new Random();
        int healthPercentage = (int) (currentEnemy.getHealth() * 100.0 / currentEnemy.getMaxHealth());
        for (Item item : currentEnemy.getInventory()) {
            if (item instanceof Consumible) {
                if(((Consumible) item).getType() == Type.Heal){
                    healingItems.add((Consumible) item);
                }
                if(((Consumible) item).getType() == Type.Damage){
                    throwableItems.add((Consumible) item);
                }
            }
        }
        //A cambiar
        if(healthPercentage < 30 && !healingItems.isEmpty()){
            enemyHeals(currentEnemy, healingItems);
        }
        else if(!throwableItems.isEmpty() && rand.nextInt(10) < 3){
            enemyTrhows(contestant, currentEnemy, throwableItems);
        }
        else{
            enemyAttack(contestant, currentEnemy);
        }
    }

    public void enemyHeals(Enemy currentEnemy, ArrayList<Consumible> healingItems){
        Consumible selectedHealingConsumible = healingItems.get(0);
        int currentEnemyHealth = currentEnemy.getHealth();
        currentEnemyHealth += selectedHealingConsumible.getPower();
        if(currentEnemyHealth > currentEnemy.getMaxHealth()){
            currentEnemyHealth = currentEnemy.getMaxHealth();
        }
        currentEnemy.setHealth(currentEnemyHealth);
        System.out.println(currentEnemy.getName() + " Has healed: " + selectedHealingConsumible.getPower() + " HP with " + selectedHealingConsumible.getName());
        selectedHealingConsumible.setDurability(selectedHealingConsumible.getDurability() - 1);
        if(selectedHealingConsumible.getDurability() <= 0){
            currentEnemy.getInventory().remove(selectedHealingConsumible);
        }
    }

    public void enemyTrhows(Player contestant, Enemy currentEnemy, ArrayList<Consumible> throwableItems){
        Consumible selectedTrhowConsumible = throwableItems.get(0);
        int currentContestantHealth = contestant.getHealth();
        currentContestantHealth -= selectedTrhowConsumible.getPower();
        System.out.println(currentEnemy.getName() + " Has trhowed: " + selectedTrhowConsumible.getName() + " and dealt: " + selectedTrhowConsumible.getPower() + " damage to " + contestant.getName());
        if(currentContestantHealth <= 0){
            currentContestantHealth = 0;
            contestant.die();
        }
        else{
            contestant.setHealth(currentContestantHealth);
        }
        selectedTrhowConsumible.setDurability(selectedTrhowConsumible.getDurability() - 1);
        if(selectedTrhowConsumible.getDurability() <= 0){
            currentEnemy.getInventory().remove(selectedTrhowConsumible);
        }
    }

    public void enemyAttack(Player contestant, Enemy currentEnemy){
        int attack;
        int playerDefence;
        int playerHealth = contestant.getHealth();
        Equipable enemyWeapon = currentEnemy.getEquipment().get(Slot.Weapon);
        int playerDice = rand.nextInt(6) +1;
        int enemyDice = rand.nextInt(6) +1;
        if(enemyWeapon != null){
            System.out.println(currentEnemy.getName() + " attacks with  " + enemyWeapon.getName());
            attack = currentEnemy.getBaseStat() + enemyWeapon.getStat() + enemyDice;
        }
        else{
            System.out.println(currentEnemy.getName() + " punch " + contestant.getName());
            attack = currentEnemy.getBaseStat() + enemyDice;
        }
        playerDefence = contestant.getBaseStat() + playerDice;
        Equipable playerWeapon = contestant.getEquipment().get(Slot.Weapon);
        for(Equipable piece : contestant.getEquipment().values()){
            if(piece != null && piece != playerWeapon){
                playerDefence += piece.getStat();
            }
        }
        if(contestant.isDefending()){
            playerDefence *= 1.5;
        }
        if(attack > playerDefence){
            System.out.println("CRITIAL HIT! " +  currentEnemy.getName() + " made " + attack + " damage");
            playerHealth -= attack;
        }
        else if(attack == playerDefence){
            System.out.println("HIT! " +  currentEnemy.getName() + " made " + attack/2 + " damage");
            playerHealth -= attack/2;
        }
        else{
            System.out.println("Blocked! " + currentEnemy + " made no damage");
            return;
        }
        if(playerHealth <= 0){
            playerHealth = 0;
            contestant.die();
        }
        else{
            contestant.setHealth(playerHealth);
        }
    }
}
