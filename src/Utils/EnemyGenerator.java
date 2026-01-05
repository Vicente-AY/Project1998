package Utils;

import java.util.Random;
import Characters.*;
import Items.*;

public class EnemyGenerator {
    Random rand = new Random();

    public Enemy generateEnemy() {
        int random = rand.nextInt(5);
        Enemy enemy;
        switch(random){
            case 0:
                enemy = new Enemy("Rata Gigante", 30, 5, 30, 3, true);
                break;
            case 1:
                enemy = new Enemy("Bandido", 60, 10, 60, 5, true);
                break;
            case 2:
                enemy = new Enemy("Esqueleto", 80, 8, 80, 3, true);
                break;
            case 3:
                enemy = new Enemy("Orco", 120, 6, 120, 10, true);
                break;
            case 4:
                enemy = new Enemy("Dragón Joven", 250, 15, 250, 25, true);
                break;
            default:
                return null;
        }
        if(enemy.getName().equals("Bandido")){
            enemy.equipItem(new Equipable("Daga", "Arma blanca de hoja corta", 10, 3, Slot.Weapon));
        }
        if(enemy.getName().equals("Esqueleto")){
            enemy.equipItem(new Equipable("Arco", "Arma para disparar flechas", 15, 5, Slot.Weapon));
        }
        if(enemy.getName().equals("Orco")){
            enemy.equipItem(new Equipable("Mazo", "Martillo grande", 20, 8, Slot.Weapon));
        }
        return enemy;
    }
}