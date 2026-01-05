package Characters;
import Items.*;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character {
    String name;
    int health;
    int reflex;
    int maxHealth;
    int baseStat;
    boolean alive = true;
    ArrayList<Item> inventory = new ArrayList<Item>();
    HashMap<Slot, Equipable> equipment = new HashMap<Slot, Equipable>();

    public Character(String name, int health, int reflex, int maxHealth, int baseStat, boolean alive) {
        this.name = name;
        this.health = health;
        this.reflex = reflex;
        this.maxHealth = maxHealth;
        this.baseStat = baseStat;
        this.alive = alive;
        this.inventory = new ArrayList<Item>();
        this.equipment = new HashMap<Slot, Equipable>();
    }

    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getReflex(){
        return reflex;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public int getBaseStat(){
        return baseStat;
    }
    public ArrayList<Item> getInventory(){
        return inventory;
    }
    public HashMap<Slot, Equipable> getEquipment(){
        return equipment;
    }
    public boolean getAlive(){
        return alive;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setReflex(int reflex) {
        this.reflex = reflex;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    public void setEquipment(HashMap<Slot, Equipable> equipment) {
        this.equipment = equipment;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }


    public void equipItem(Equipable equipable){
        this.equipment.put(equipable.getSlot(), equipable);
    }
    public void die(){
        this.alive = false;
    }


}
