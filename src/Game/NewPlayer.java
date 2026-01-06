package Game;
import Characters.*;
import Items.*;

import java.util.Scanner;

public class NewPlayer {

    public Player playerCreation(){
        System.out.println("Welcome to player creation");
        System.out.println("Introduce your character´s Name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Player newPlayer = new Player(name, 100, 10, 100, 5, true);
        newPlayer.getInventory().add(new Consumible("Poción de Vida", "Restaura salud al instante", 1, 50, Type.Heal));
        newPlayer.getInventory().add(new Consumible("Bomba de Fuego", "Causa daño de fuego en área", 1, 60, Type.Damage));
        return newPlayer;
    }
}
