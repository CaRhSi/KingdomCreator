import java.util.Random;
import java.util.Scanner;

// Knight class extending Villager with additional attributes for strength, weapon, and armor
public class Knight extends Villager {
    private int strength; // Strength attribute
    private Weapon weapon; // Weapon attribute
    private Armor armor; // Armor attribute

    // Constructor for Knight
    public Knight(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.strength = generateStrength();
        this.weapon = selectWeapon();
        this.armor = selectArmor();
    }

    // Getter for strength
    public int getStrength() {
        return strength;
    }

    // Getter for weapon
    public Weapon getWeapon() {
        return weapon;
    }

    // Getter for armor
    public Armor getArmor() {
        return armor;
    }

    // Method to generate a random strength value between 1 and 10
    private int generateStrength() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    // Method to select a weapon for the knight
    private Weapon selectWeapon() {
        Scanner scanner = new Scanner(System.in);
        Weapon selectedWeapon = null;
        boolean validSelection = false;

        // Loop until a valid weapon is selected
        while (!validSelection) {
            System.out.println("Select a weapon for the knight:");
            for (Weapon weapon : Weapon.values()) {
                System.out.println("- " + weapon);
            }
            String input = scanner.nextLine().toUpperCase();

            // Check if the input matches any of the weapons
            for (Weapon weapon : Weapon.values()) {
                if (weapon.name().equals(input)) {
                    selectedWeapon = weapon;
                    validSelection = true;
                    break;
                }
            }

            if (!validSelection) {
                System.out.println("Invalid weapon selection. Please try again.");
            }
        }

        return selectedWeapon;
    }

    // Method to select an armor for the knight
    private Armor selectArmor() {
        Scanner scanner = new Scanner(System.in);
        Armor selectedArmor = null;
        boolean validSelection = false;

        // Loop until a valid armor is selected
        while (!validSelection) {
            System.out.println("Select an armor for the knight:");
            for (Armor armor : Armor.values()) {
                System.out.println("- " + armor);
            }
            String input = scanner.nextLine().toUpperCase();

            // Check if the input matches any of the armors
            for (Armor armor : Armor.values()) {
                if (armor.name().equals(input)) {
                    selectedArmor = armor;
                    validSelection = true;
                    break;
                }
            }

            if (!validSelection) {
                System.out.println("Invalid armor selection. Please try again.");
            }
        }

        return selectedArmor;
    }

    // Overridden method to print the knight's stats
    @Override
    public void printStats() {
        System.out.println("Knight: " + getFullName() + ", Age: " + getAge());
        System.out.println("  Strength: " + getStrength());
        System.out.println("  Weapon: " + getWeapon());
        System.out.println("  Armor: " + getArmor());
    }
}
