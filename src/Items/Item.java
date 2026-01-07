package Items;

public abstract class Item {
    String name;
    String description;
    int durability;

    public Item(String name, String description, int durability) {
        this.name = name;
        this.description = description;
        this.durability = durability;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }

}
