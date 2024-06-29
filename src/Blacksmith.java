public class Blacksmith extends Villager {
    public Blacksmith(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    @Override
    public void printStats() {
        System.out.println("Blacksmith: " + getFullName() + ", Age: " + getAge());
    }
}
