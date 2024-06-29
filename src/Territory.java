import java.util.ArrayList;
import java.util.Scanner;

public class Territory {
    private String name; // Name of the territory
    private TerritoryType type; // Type of the territory
    private ArrayList<Building> buildings; // List of buildings in the territory

    // Constructor for the Territory class
    public Territory() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the type of the territory
        System.out.print("Select the type of your territory (Kingdom/Dynasty/Empire): ");
        String territoryTypeInput = scanner.nextLine().toUpperCase();
        while (!isValidTerritoryType(territoryTypeInput)) {
            System.out.print("Invalid type. Please select Kingdom, Dynasty, or Empire: ");
            territoryTypeInput = scanner.nextLine().toUpperCase();
        }
        this.type = TerritoryType.valueOf(territoryTypeInput);

        // Prompt the user for the name of the territory
        System.out.print("Enter the name of your " + territoryTypeInput.toLowerCase() + ": ");
        this.name = scanner.nextLine();

        this.buildings = new ArrayList<>();
    }

    // Helper method to validate the territory type
    private boolean isValidTerritoryType(String input) {
        for (TerritoryType type : TerritoryType.values()) {
            if (type.name().equals(input)) {
                return true;
            }
        }
        return false;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for type
    public TerritoryType getType() {
        return type;
    }

    // Getter for buildings
    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    // Method to add a building to the territory
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    // Method to print the structure of the territory
    public void printStructure() {
        System.out.println(type.toString() + " of " + name); // Print the type and name of the territory
        for (Building building : buildings) { // Iterate through each building in the list
            System.out.println("  Building: " + building.getName() + " (" + building.getType() + ")"); // Print the name and type of the building
            building.printVillagers(); // Print the villagers assigned to the building
        }
    }

    // Method to display buildings and their occupants
    public void displayBuildingsAndOccupants() {
        for (Building building : buildings) {
            System.out.print("Building: " + building.getName() + " (" + building.getType() + ")");
            if (building.getVillagers().isEmpty()) {
                System.out.println(" - Empty");
            } else {
                System.out.print(" - Occupants: ");
                for (Villager villager : building.getVillagers()) {
                    System.out.print(villager.getFullName() + " ");
                }
                System.out.println();
            }
        }
    }
}
