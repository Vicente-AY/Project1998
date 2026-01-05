package Characters;

public class Enemy extends Character{
    public Enemy(String name, int health, int reflex, int maxHealth, int baseStat, boolean alive){
        super(name, health, reflex, maxHealth, baseStat, alive);

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
}