import Characters.*;
import Utils.*;
import Items.*;

public class Main{
    public static void main(String[] args){
        EnemyGenerator gen = new EnemyGenerator();
        Enemy malo = gen.generateEnemy();
        System.out.println("Ha aparecido un: " + malo.getName());
        Equipable arma = malo.getEquipment().get(Slot.Weapon);
        System.out.println("Va armado con un: " + arma.getName());
    }
}