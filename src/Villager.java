public abstract class Villager {
    protected String firstName;
    protected String lastName;
    protected int age;

    // Constructor for Villager
    public Villager(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Method to get full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Abstract method to print stats
    public abstract void printStats();
}
