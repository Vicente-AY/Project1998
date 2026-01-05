package Game;
import Characters.*;
import java.util.Scanner;

public class NewPlayer {

    public Player playerCreation(){
        System.out.println("Welcome to player creation");
        System.out.println("Introduce your character´s Name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Player newPlayer = new Player(name, 100, 10, 100, 5, true);
        return newPlayer;
    }
}
