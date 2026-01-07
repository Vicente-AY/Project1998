package Items;

public class Equipable extends Item {
    Slot slot;
    int stat;

    public Equipable(String name, String description, int durability, int stat, Slot slot){
        super(name, description, durability);
        this.stat = stat;
        this.slot = slot;
    }
    public Slot getSlot(){
        return slot;
    }
    public void setSlot(Slot slot){
        this.slot = slot;
    }
    public int getStat(){
        return stat;
    }
    public void setStat(int stat){
        this.stat = stat;
    }
}