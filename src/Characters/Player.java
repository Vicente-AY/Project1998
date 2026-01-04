package Characters;

import Items.Item;

import java.util.ArrayList;

public abstract class Player {
    String name;
    int health;
    int reflex;
    ArrayList<Item> inventory = new ArrayList<Item>();

    Player(String name, int health, int reflex){
        this.name = name;
        this.health = health;
        this.reflex = reflex;
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
    public void setName(String name){
        this.name = name;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setReflex(int reflex){
        this.reflex = reflex;
    }

    public void attack(){
        System.out.println("attack");
    }
    public void defense(){
        System.out.println("defense");
    }
    public void retreat(){
        System.out.println("retreat");
    }


}
