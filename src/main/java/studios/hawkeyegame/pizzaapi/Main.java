package studios.hawkeyegame.pizzaapi;

public class Main {

    public static void main(String[] args) {
        Address address = new Address("", "", "");

        try {
            address.getStores();
        } catch (Exception ignored) {}
    }
}