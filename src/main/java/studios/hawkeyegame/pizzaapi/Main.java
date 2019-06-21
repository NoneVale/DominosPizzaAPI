package studios.hawkeyegame.pizzaapi;

public class Main {

    public static void main(String[] args) {
        Address address = new Address("2557 Lakewalk Cove", "Casselberry", "Florida", "32707", "USA");

        try {
            address.getStores();
        } catch (Exception ignored) {}
    }
}