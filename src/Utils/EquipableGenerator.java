package Utils;
import Items.Equipable;
import Items.Slot;
import java.util.Random;

public class EquipableGenerator {
    Random rand = new Random();
    public Equipable randomEquipable(){
        int index = rand.nextInt(5);
        switch(index){
            case 0:
                return randomHead();
            case 1:
                return randomChest();
            case 2:
                return randomLeg();
            case 3:
                return randomFoot();
            case 4:
                return randomWeapon();
            default:
                return null;
        }
    }

    public Equipable randomHead(){
        int index = rand.nextInt(5);
        switch(index){
            case 0:
                return new Equipable("Casco de Cuero", "Un casco sencillo de cuero", 40, 2, Slot.Head);
            case 1:
                return new Equipable("Casco de Hierro", "Casco resistente de hierro", 80, 5, Slot.Head);
            case 2:
                return new  Equipable("Casco de Acero", "Protección sólida para la cabeza", 120, 7, Slot.Head);
            case 3:
                return new Equipable("Casco Élfico", "Ligero y elegante", 90, 6, Slot.Head);
            case 4:
                return new Equipable("Casco Legendario", "Imbuido con magia antigua", 150, 10, Slot.Head);
            default:
                return null;
        }
    }

    public Equipable randomChest(){
        int index = rand.nextInt(5);
        switch(index){
            case 0:
                return new Equipable("Pechera de Cuero", "Armadura ligera", 60, 4, Slot.Chest);
            case 1:
                return new Equipable("Pechera de Hierro", "Armadura pesada y resistente", 120, 8, Slot.Chest);
            case 2:
                return new Equipable("Pechera de Acero", "Excelente protección", 180, 12, Slot.Chest);
            case 3:
                return new Equipable("Pechera Élfica", "Diseño ligero y flexible", 140, 10, Slot.Chest);
            case 4:
                return new Equipable("Pechera Legendaria", "Protección suprema", 220, 18, Slot.Chest);
            default:
                return null;
        }
    }

    public Equipable randomLeg(){
        int index = rand.nextInt(5);
        switch(index){
            case 0:
                return new Equipable("Grebas de Cuero", "Protección básica para las piernas", 50, 3, Slot.Legs);
            case 1:
                return new Equipable("Grebas de Hierro", "Grebas robustas", 100, 6, Slot.Legs);
            case 2:
                return new Equipable("Grebas de Acero", "Alta resistencia", 150, 9, Slot.Legs);
            case 3:
                return new Equipable("Grebas Élficas", "Cómodas y ligeras", 120, 8, Slot.Legs);
            case 4:
                return new Equipable("Grebas Legendarias", "Forjadas por maestros antiguos", 180, 14, Slot.Legs);
            default:
                return null;
        }
    }

    public Equipable randomFoot(){
        int index = rand.nextInt(5);
        switch(index){
            case 0:
                return new Equipable("Botas de Cuero", "Botas sencillas", 40, 2, Slot.Foot);
            case 1:
                return new Equipable("Botas de Hierro", "Botas pesadas", 80, 4, Slot.Foot);
            case 2:
                return new Equipable("Botas de Acero", "Botas resistentes", 120, 6, Slot.Foot);
            case 3:
                return new Equipable("Botas Élficas", "Aumentan la agilidad", 100, 7, Slot.Foot);
            case 4:
                return new Equipable("Botas Legendarias", "Permiten moverse con gran velocidad", 140, 10, Slot.Foot);
            default:
                return null;
        }
    }

    public Equipable randomWeapon(){
        int index = rand.nextInt(5);
        switch(index){
            case 0:
                return new Equipable("Espada Corta", "Arma básica de combate", 60, 6, Slot.Weapon);
            case 1:
                return new Equipable("Espada Larga", "Mayor alcance y daño", 100, 10, Slot.Weapon);
            case 2:
                return new Equipable("Hacha de Guerra", "Devastadora a corta distancia", 120, 12, Slot.Weapon);
            case 3:
                return new Equipable("Arco Élfico", "Preciso y ligero", 90, 11, Slot.Weapon);
            case 4:
                return new Equipable("Espada Legendaria", "Arma de poder inmenso", 180, 20, Slot.Weapon);
            default:
                return null;
        }
    }
}