import java.util.ArrayList;

// Building class representing a building in the territory
public class Building {
    private String name; // Name of the building
    private BuildingType type; // Type of the building
    private ArrayList<Villager> villagers; // List of villagers assigned to the building

    // Constructor for Building
    public Building(String name, BuildingType type) {
        this.name = name;
        this.type = type;
        this.villagers = new ArrayList<>();
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for type
    public BuildingType getType() {
        return type;
    }

    // Getter for villagers
    public ArrayList<Villager> getVillagers() {
        return villagers;
    }

    // Method to add a villager to the building
    public void addVillager(Villager villager) {
        villagers.add(villager);
    }

    // Method to print the villagers assigned to the building
    public void printVillagers() {
        for (Villager villager : villagers) {
            villager.printStats();
        }
    }
}
