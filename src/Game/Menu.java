package Game;
import java.util.Scanner;
import Characters.*;

public class Menu {
    Wait waitInst =  new Wait();
    Player newPlayer = null;
    Scanner sc = new Scanner(System.in);
    NewPlayer newPlayerInst = new NewPlayer();

    public void gameMenu(){
        while(true){
            System.out.println("Welcome to the Game Menu");
            System.out.println("Choose your action");
            System.out.println("1. New Game");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    newPlayer = newPlayerInst.playerCreation();
                    waitInst.waitStage(newPlayer);
                    break;
                case 2:
                    System.out.println("Thanks for playing!");
                    return;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
}
