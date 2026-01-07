package Utils;
import Items.*;
import java.util.Random;

public class ConsumibleGenerator {
    Random rand = new Random();

    public Consumible generateConsumible() {
        int random = rand.nextInt(6);
        switch(random){
            case 0:
                return new Consumible("Poción de Vida", "Restaura salud al instante", 1, 50, Type.Heal);
            case 1:
                return new Consumible("Poción de Energía", "Recupera energía o maná", 1, 40, Type.Heal);
            case 2:
                return new Consumible("Pergamino de Regeneración", "Recupera mucha salud", 1, 100, Type.Heal);
            case 3:
                return new Consumible("Bomba Pequeña", "Explota y daña a los enemigos", 1, 30, Type.Damage);
            case 4:
                return new Consumible("Bomba de Fuego", "Causa daño de fuego en área", 1, 60, Type.Damage);
            case 5:
                return new Consumible("Veneno Concentrado", "Inflige daño prolongado", 1, 45, Type.Damage);
            default:
                return null;
        }
    }
}
