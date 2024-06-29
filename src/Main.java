import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new Territory
        Territory territory = new Territory();

        // Populate the territory with buildings
        System.out.print("Enter the number of buildings in your " + territory.getType().toString().toLowerCase() + ": ");
        int numberOfBuildings = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfBuildings; i++) {
            System.out.print("Enter the name of building " + (i + 1) + ": ");
            String buildingName = scanner.nextLine();

            System.out.print("Select the type of building " + (i + 1) + " (Smithy/House/Barracks): ");
            String buildingTypeInput = scanner.nextLine().toUpperCase();
            while (!isValidBuildingType(buildingTypeInput)) {
                System.out.print("Invalid type. Please select Smithy, House, or Barracks: ");
                buildingTypeInput = scanner.nextLine().toUpperCase();
            }
            BuildingType buildingType = BuildingType.valueOf(buildingTypeInput);

            Building building = new Building(buildingName, buildingType);
            territory.addBuilding(building);
        }

        // Add villagers to the territory
        boolean addingVillagers = true;
        while (addingVillagers) {
            System.out.print("Enter the first name of the villager: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter the last name of the villager: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter the age of the villager: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Villager villager = null;
            while (villager == null) {
                System.out.print("Enter the profession of the villager (Knight/Blacksmith/Farmer): ");
                String profession = scanner.nextLine();

                // Create villager based on the profession
                switch (profession.toLowerCase()) {
                    case "knight":
                        villager = new Knight(firstName, lastName, age);
                        break;
                    case "blacksmith":
                        villager = new Blacksmith(firstName, lastName, age);
                        break;
                    case "farmer":
                        villager = new Farmer(firstName, lastName, age);
                        break;
                    default:
                        System.out.println("Invalid profession. Please enter Knight, Blacksmith, or Farmer.");
                        break;
                }
            }

            boolean buildingFound = false;
            while (!buildingFound) {
                // Display buildings and their occupants
                System.out.println("Available buildings and their occupants:");
                territory.displayBuildingsAndOccupants();

                System.out.print("Enter the name of the building to assign the villager to: ");
                String buildingName = scanner.nextLine();

                // Assign the villager to the specified building
                for (Building building : territory.getBuildings()) {
                    if (building.getName().equals(buildingName)) {
                        building.addVillager(villager);
                        buildingFound = true;
                        break;
                    }
                }

                if (!buildingFound) {
                    System.out.println("Building not found. Please enter a valid building name.");
                }
            }

            System.out.print("Do you want to add another villager? (yes/no): ");
            String continueAdding = scanner.nextLine();
            if (!continueAdding.equalsIgnoreCase("yes")) {
                addingVillagers = false;
            }
        }

        // Print the structure of the territory
        territory.printStructure();
        scanner.close();
    }

    // Helper method to validate the building type
    private static boolean isValidBuildingType(String input) {
        for (BuildingType type : BuildingType.values()) {
            if (type.name().equals(input)) {
                return true;
            }
        }
        return false;
    }
}
