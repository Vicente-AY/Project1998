package Items;

public class Consumible extends Item {
    int power;

    public Consumible(String name, String description, int durability, int power){
        super(name, description, durability);
        this.power = power;
    }

    public void use(){
        System.out.println("use on player");
    }
    public void toss(){
        System.out.println("toss on enemy");

    }
}
