package Game;
import Characters.*;
import java.util.Scanner;

public class Wait {
    Scanner sc  = new Scanner(System.in);
    int iterations = 0;

    public void waitStage(Player contestant){
        Combat combat = new Combat();
        System.out.println("Combat Finished");
        System.out.println("What do you want to do?");
        System.out.println("1. Next Combat");
        System.out.println("2. Use Consumable");
        System.out.println("3. Exit Game");

        while(true){
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                combat.combatStage(contestant);
                iterations++;
                break;
            case 2:
                //consumable();
                break;
            case 3:
                return;
            default:
                System.out.println("Not valid choice");
                break;
        }
        }
    }


}
