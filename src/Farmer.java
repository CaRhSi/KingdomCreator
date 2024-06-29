// Farmer class extending Villager
public class Farmer extends Villager {
    // Constructor for Farmer
    public Farmer(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    // Overridden method to print the farmer's stats
    @Override
    public void printStats() {
        System.out.println("Farmer: " + getFullName() + ", Age: " + getAge());
    }
}
