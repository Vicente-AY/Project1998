package Items;

public class Consumible extends Item {
    int power;
    Type type;

    public Consumible(String name, String description, int durability, int power, Type type){
        super(name, description, durability);
        this.power = power;
        this.type = type;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public void use(){
        System.out.println("use on player");
    }
    public void toss(){
        System.out.println("toss on enemy");

    }
}
