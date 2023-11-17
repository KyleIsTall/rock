import java.util.Random;
import java.util.Scanner;

public class Banana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Enemy rock = new Enemy("Rock", 10, 5);
        Weapon sword = new Weapon("Wooden Sword", 3, 0);

        Weapon[] swords = {
                new Weapon("Bronze Sword", 5,15), // 0
                new Weapon("Silver Sword",10, 30), // 1
                new Weapon("Gold Sword", 25, 70), // 2
                new Weapon("Diamond Sword", 70, 150),
                new Weapon("Netherite Sword", 500,2000 )
        };
        int iterations = 0;
        int gold = 0;
        int currentSwordLevel = -1;

        while (true) {
            System.out.println(iterations);
            System.out.println("\n\nGold: " + gold + "\nPress 1 - To hit Rock\nPress 2 - Sword Shop\nChoice: ");
            int selection = scanner.nextInt();

            if (selection == 1) {
                rock.takeDamage(sword);

                if (rock.health <= 0) {
                    System.out.println("Rock is ded\n");
                    gold += rock.rewards;
                    System.out.println("\nYou gained " + rock.rewards + " gold!");
                    iterations++;
                    int baseReward = 5 * iterations;
                    int reward = (int) (Math.random() * baseReward * 2) + baseReward;
                    rock = new Enemy("rock" + iterations, 10 * iterations, reward);
                } else {
                    rock.outputHealth();
                }
            } else if (selection == 2) {
                boolean canBuyAnything = false;
                for (Weapon weapon : swords) {
                    if (!weapon.owned && gold >= weapon.cost) {
                        System.out.println(weapon.weaponName + " is available to buy!\nPress 1 to buy and 2 to ignore!");
                        canBuyAnything = true;
                        if (scanner.nextInt() == 1) {
                            currentSwordLevel++;
                            sword = swords[currentSwordLevel];
                            swords[currentSwordLevel].owned = true;
                            gold -= weapon.cost;
                            System.out.println(weapon.weaponName + " bought successfully!");
                        }
                        break;
                    }
                }
                if (!canBuyAnything) {
                    System.out.println("Come back when you have enough gold!");
                }
            }
        }
    }
}


